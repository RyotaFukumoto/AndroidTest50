package com.example.ryota.androidtest39;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class RecordActivity extends Activity {

    private Camera myCamera;
    private SurfaceView mySurfaceView;

    private final SimpleDateFormat photoName = new SimpleDateFormat("yyy-MM-dd-HHmmss", Locale.JAPAN);

    private SensorManager mySensor;

    private static final int MATRIX_SIZE = 16;
    private static final int DIMENSION = 3;

    private float[] magneticValues = new float[DIMENSION];
    private float[] accelerometerValues = new float[DIMENSION];
    private final float[] orientationValues = new float[DIMENSION];



    private final Camera.PictureCallback mPictureListener =
            new Camera.PictureCallback() {

                @Override
                public void onPictureTaken(byte[] data, Camera camera) {
                    ContentResolver resolver = getContentResolver();

                    int svWidth = RecordActivity.this.mySurfaceView.getHolder().getSurfaceFrame().width();
                    int cWidth = camera.getParameters().getSupportedPreviewSizes().get(0).width;

                    // データを生成する
                    Bitmap tmp_bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                    int width = tmp_bitmap.getWidth();
                    int height = tmp_bitmap.getHeight();

                    // 画像データを回転する
                    int rad_y = radianToDegree(RecordActivity.this.orientationValues[2]);
                    Matrix matrix = new Matrix();
                    if(isaBoolean(rad_y, -45, 0, rad_y > 0, 45)) {
                        matrix.setRotate(90.0F);
                    } else if (rad_y > 45 && rad_y <= 135) {
                        matrix.setRotate(180.0F);
                    } else if (isaBoolean(rad_y, 135, 180, rad_y >= -180, -135)) {
                        matrix.setRotate(-90.0F);
                    } else if (rad_y > -135 && rad_y <= -45) {
                        matrix.setRotate((float) 0);
                    }

                    Log.i("Cam",width + " , " + height);

                    // 画像データを保存する
                    Bitmap temp_bitmap = Bitmap.createBitmap(tmp_bitmap, 0, 0, width, height, matrix, true);

                    int temp_width = (height * svWidth) / cWidth ;
                    Log.i("Cam", temp_width + " : " + width );
                    Bitmap bitmap = Bitmap.createBitmap(temp_bitmap, 0, 0, temp_width, width, null, true);

                    MyApplication app = (MyApplication) getApplication();
                    app.setObj(bitmap);
                    Intent intent = new Intent();
                    setResult(1010,intent);
                    finish();
                }

                private boolean isaBoolean(int rad_y, int i, int i2, boolean b, int i3) {
                    return (rad_y > i && rad_y <= i2) || (b && rad_y <= i3);
                }
            };

    /**
     * SurfaceView
     * 生成・変更・破棄
     */
    private final SurfaceHolder.Callback mSurfaceListener =
            new SurfaceHolder.Callback() {
                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {
                    RecordActivity.this.myCamera.stopPreview();
                    RecordActivity.this.myCamera.release();
                    RecordActivity.this.myCamera = null;
                }

                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    RecordActivity.this.myCamera = Camera.open();
                    try {
                        RecordActivity.this.myCamera.setPreviewDisplay(holder);
                    } catch (IOException e) {
                        Log.e("System.err",e.getMessage());
                    } catch (RuntimeException e) {
                        Log.e("System.err",e.getMessage());
                    }
                }

                @Override
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                    RecordActivity.this.myCamera.stopPreview();

                    Camera.Parameters parameters = RecordActivity.this.myCamera.getParameters();

                    // 画面の向きを設定
                    boolean portrait = isPortrait();
                    if (portrait) {
                        RecordActivity.this.myCamera.setDisplayOrientation(90);
                    } else {
                        RecordActivity.this.myCamera.setDisplayOrientation(0);
                    }

                    // 対応するプレビューサイズ・保存サイズを取得する
                    List<Camera.Size> previewSizes = parameters.getSupportedPreviewSizes();
                    List<Camera.Size> pictureSizes = parameters.getSupportedPictureSizes();

                    Camera.Size previewSize = getOptimalPreviewSize(previewSizes, width, height);
                    Camera.Size pictureSize = pictureSizes.get(0);

                    Log.d("CameraTest", "surface = " +
                            String.valueOf(width) + " , " +
                            String.valueOf(height));
                    if (previewSize == null) {
                        throw new AssertionError();
                    }
                    Log.d("CameraTest", "preview = " +
                            String.valueOf(previewSize.width) + " , " +
                            String.valueOf(previewSize.height));
                    Log.d("CameraTest", "picture = " +
                            String.valueOf(pictureSize.width) + " , " +
                            String.valueOf(pictureSize.height));

                    parameters.setPreviewSize(previewSize.width, previewSize.height);
                    parameters.setPictureSize(pictureSize.width, pictureSize.height);

                    // カメラプレビューレイアウトの設定
                    int previewWidth = previewSize.width;
//                    int previewWidth = getWindowManager().getDefaultDisplay().getWidth();
                    int previewHeight = previewSize.height;
//                    int previewHeight = getWindowManager().getDefaultDisplay().getHeight();
                    android.view.ViewGroup.LayoutParams layoutParams = RecordActivity.this.mySurfaceView.getLayoutParams();
                    if (portrait) {
                        layoutParams.width = previewHeight;
                        layoutParams.height = previewWidth;
                    } else {
                        layoutParams.width = previewWidth;
                        layoutParams.height = previewHeight;
                    }
                    RecordActivity.this.mySurfaceView.setLayoutParams(layoutParams);

                    // パラメータを設定してカメラを再開
                    RecordActivity.this.myCamera.setParameters(parameters);
                    RecordActivity.this.myCamera.startPreview();
                }
            };

    /**
     * オートフォーカス処理
     */
    private final Camera.AutoFocusCallback mAutoFocusListener =
            new Camera.AutoFocusCallback() {

                @Override
                public void onAutoFocus(boolean success, Camera camera) { }
            };

    /**
     * センサー制御
     */
    private final SensorEventListener mSensorEventListener =
            new SensorEventListener() {

                @Override
                public void onSensorChanged(SensorEvent event) {
                    if (event.accuracy == SensorManager.SENSOR_STATUS_UNRELIABLE) {
                        return;
                    }

                    switch (event.sensor.getType()) {
                        case Sensor.TYPE_MAGNETIC_FIELD:
                            // 地磁気センサ
                            RecordActivity.this.magneticValues = event.values.clone();
                            break;
                        case Sensor.TYPE_ACCELEROMETER:
                            // 加速度センサ
                            RecordActivity.this.accelerometerValues = event.values.clone();
                            break;

                        default:
                            break;

                    }

                    if (RecordActivity.this.magneticValues != null && RecordActivity.this.accelerometerValues != null) {
                        float[] rotationMatrix = new float[MATRIX_SIZE];
                        float[] inclinationMatrix = new float[MATRIX_SIZE];

                        // 加速度センサと地磁気センタから回転行列を取得
                        SensorManager.getRotationMatrix(rotationMatrix, inclinationMatrix, RecordActivity.this.accelerometerValues, RecordActivity.this.magneticValues);

                        float[] remapedMatrix = new float[MATRIX_SIZE];
                        SensorManager.remapCoordinateSystem(rotationMatrix, SensorManager.AXIS_X, SensorManager.AXIS_Z, remapedMatrix);
                        SensorManager.getOrientation(remapedMatrix, RecordActivity.this.orientationValues);
                    }
                }

                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) { }
            };

    /**
     * 画面の向きを取得する
     */
    private boolean isPortrait() {
        return (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT);
    }

    @Nullable
    private Camera.Size getOptimalPreviewSize(List<Camera.Size> sizes, int w, int h) {
        double targetRatio = (double) w / (double) h;
        if (sizes == null) {
            return null;
        }

        Camera.Size optimalSize = null;
        double minDiff = Double.MAX_VALUE;

        // Try to find an size match aspect ratio and size
        double ASPECT_TOLERANCE = 0.1;
        for (Camera.Size size : sizes) {
            double ratio = (double) size.width / size.height;
            if (Math.abs(ratio - targetRatio) > ASPECT_TOLERANCE) {
                continue;
            }
            if (Math.abs(size.height - h) < minDiff) {
                optimalSize = size;
                minDiff = Math.abs(size.height - h);
            }
        }

        // Cannot find the one match the aspect ratio, ignore the requirement
        if (optimalSize == null) {
            double maxValue = Double.MAX_VALUE;
            for (Camera.Size size : sizes) {
                if (Math.abs(size.height - h) < maxValue) {
                    optimalSize = size;
                    maxValue = Math.abs(size.height - h);
                }
            }
        }
        return optimalSize;
    }

    private int radianToDegree(float rad) {
        return (int)Math.floor(Math.toDegrees((double) rad));
    }

    /**
     * 画面タッチ時でオートフォーカスを実装
     */
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Camera.Parameters params = this.myCamera.getParameters();
            if (!params.getFocusMode().equals(Camera.Parameters.FOCUS_MODE_FIXED)) {
                this.myCamera.autoFocus(this.mAutoFocusListener);
            }
        }
        return true;
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 全画面設定
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_record);

        findViewById(R.id.flushButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecordActivity.this.myCamera.takePicture(null,null, RecordActivity.this.mPictureListener);
            }
        });

        // カメラプレビューの設定
        this.mySurfaceView = (SurfaceView)findViewById(R.id.surfaceView);
        SurfaceHolder holder = this.mySurfaceView.getHolder();
        holder.addCallback(this.mSurfaceListener);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        // センサーを取得する
        this.mySensor = (SensorManager)getSystemService(SENSOR_SERVICE);
    }

    @Override
    public void onResume() {
        super.onResume();

        // 地磁気センサ
        this.mySensor.registerListener(this.mSensorEventListener,
                this.mySensor.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                SensorManager.SENSOR_DELAY_UI);

        // 加速度センサ
        this.mySensor.registerListener(this.mSensorEventListener,
                this.mySensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        super.onPause();
        this.mySensor.unregisterListener(this.mSensorEventListener);
    }

}