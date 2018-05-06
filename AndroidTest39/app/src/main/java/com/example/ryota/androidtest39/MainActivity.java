package com.example.ryota.androidtest39;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private boolean mPermissionReady;
    private boolean cameraPreviewing;
    private android.hardware.Camera myCamera;
    private SurfaceView mySurfaceView;
    private final SimpleDateFormat photoName = new SimpleDateFormat("yyy-MM-dd-HHmmss", Locale.JAPAN);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        this.cameraPreviewing = false;

        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.imageView.setClickable(true);
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(MainActivity.this.cameraPreviewing){
                    MainActivity.this.myCamera.takePicture(null,null, MainActivity.this.mPictureListener);
                    button.setText("起動");
                    MainActivity.this.cameraPreviewing = false;
                } else {
                    if (MainActivity.this.mPermissionReady) {
                        MainActivity.this.mySurfaceView = (SurfaceView)findViewById(R.id.surfaceView);
                        SurfaceHolder holder = MainActivity.this.mySurfaceView.getHolder();
                        holder.addCallback(MainActivity.this.mSurfaceListener);
                        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
                        MainActivity.this.mySurfaceView.setVisibility(View.VISIBLE);
                        MainActivity.this.imageView.setVisibility(View.GONE);
                        button.setText(R.string.flush);
                        MainActivity.this.cameraPreviewing = true;
                    }
                }
            }
        });


        int cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        int storagePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        this.mPermissionReady = cameraPermission == PackageManager.PERMISSION_GRANTED
                && storagePermission == PackageManager.PERMISSION_GRANTED;
        if (!this.mPermissionReady) {
            requirePermissions();
        }
    }

    private void requirePermissions() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, 11);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Map<String, Integer> perm = new HashMap<>();
        perm.put(Manifest.permission.CAMERA, PackageManager.PERMISSION_DENIED);
        perm.put(Manifest.permission.WRITE_EXTERNAL_STORAGE, PackageManager.PERMISSION_DENIED);
        for (int i = 0; i < permissions.length; i++) {
            perm.put(permissions[i], grantResults[i]);
        }
        if (perm.get(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                && perm.get(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            this.mPermissionReady = true;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }



    private final SurfaceHolder.Callback mSurfaceListener =
            new SurfaceHolder.Callback() {
                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {
                    MainActivity.this.myCamera.stopPreview();
                    MainActivity.this.myCamera.release();
                    MainActivity.this.myCamera = null;
                }

                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    MainActivity.this.myCamera = android.hardware.Camera.open();
                    String errTag = "System.err";
                    try {
                        MainActivity.this.myCamera.setPreviewDisplay(holder);
                    } catch (IOException e) {
                        Log.e(errTag,e.getMessage());
                    } catch (RuntimeException e) {
                        Log.e(errTag,e.getMessage());
                    }
                }

                @Override
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                    MainActivity.this.myCamera.stopPreview();

                    android.hardware.Camera.Parameters parameters = MainActivity.this.myCamera.getParameters();

                    MainActivity.this.myCamera.setDisplayOrientation(90);


                    List<android.hardware.Camera.Size> previewSizes = parameters.getSupportedPreviewSizes();
                    List<android.hardware.Camera.Size> pictureSizes = parameters.getSupportedPictureSizes();

                    android.hardware.Camera.Size previewSize = getOptimalPreviewSize(previewSizes, width, height);
                    android.hardware.Camera.Size pictureSize = pictureSizes.get(0);

                    if (previewSize == null) {
                        throw new AssertionError();
                    }

                    parameters.setPreviewSize(previewSize.width, previewSize.height);
                    parameters.setPictureSize(pictureSize.width, pictureSize.height);


                    int previewWidth = getWindowManager().getDefaultDisplay().getHeight();
                    int previewHeight = getWindowManager().getDefaultDisplay().getWidth();
                    android.view.ViewGroup.LayoutParams layoutParams = MainActivity.this.mySurfaceView.getLayoutParams();

                    layoutParams.width = previewHeight;
                    layoutParams.height = previewWidth;

                    MainActivity.this.mySurfaceView.setLayoutParams(layoutParams);

                    MainActivity.this.myCamera.setParameters(parameters);
                    MainActivity.this.myCamera.startPreview();
                }
            };


    private final android.hardware.Camera.AutoFocusCallback mAutoFocusListener =
            new android.hardware.Camera.AutoFocusCallback(){

                @Override
                public void onAutoFocus(boolean success, android.hardware.Camera camera) {

                }

            };

    private final android.hardware.Camera.PictureCallback mPictureListener =
            new android.hardware.Camera.PictureCallback() {
                @Override
                public void onPictureTaken(byte[] data, android.hardware.Camera camera) {
                    ContentResolver resolver = getContentResolver();

                    int svWidth = MainActivity.this.mySurfaceView.getHolder().getSurfaceFrame().width();
                    int cWidth = camera.getParameters().getSupportedPreviewSizes().get(0).width;
                    Bitmap tmp_bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                    int width = tmp_bitmap.getWidth();
                    int height = tmp_bitmap.getHeight();

                    Matrix matrix = new Matrix();
                    matrix.setRotate(90.0F);

                    Bitmap temp_bitmap = Bitmap.createBitmap(tmp_bitmap, 0, 0, width, height, matrix, true);

                    MainActivity.this.imageView.setImageBitmap(temp_bitmap);
                    MainActivity.this.imageView.setVisibility(View.VISIBLE);
                    MainActivity.this.mySurfaceView.setVisibility(View.INVISIBLE);
                }

            };

    @Nullable
    private android.hardware.Camera.Size getOptimalPreviewSize(List<android.hardware.Camera.Size> sizes, int w, int h) {
        double targetRatio = (double) w / (double) h;
        if (sizes == null) {
            return null;
        }

        android.hardware.Camera.Size optimalSize = null;
        double minDiff = Double.MAX_VALUE;

        // Try to find an size match aspect ratio and size
        double ASPECT_TOLERANCE = 0.1;
        for (android.hardware.Camera.Size size : sizes) {
            double ratio = (double) size.width / (double) size.height;
            if (Math.abs(ratio - targetRatio) > ASPECT_TOLERANCE) {
                if ((double) Math.abs(size.height - h) < minDiff) {
                    optimalSize = size;
                    minDiff = (double) Math.abs(size.height - h);
                }
            }

        }

        if (optimalSize == null) {
            double maxValue = Double.MAX_VALUE;
            for (android.hardware.Camera.Size size : sizes) {
                if ((double) Math.abs(size.height - h) < maxValue) {
                    optimalSize = size;
                    maxValue = (double) Math.abs(size.height - h);
                }
            }
        }
        return optimalSize;
    }

    private int radianToDegree(float rad) {
        return (int)Math.floor(Math.toDegrees((double) rad));
    }


    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            android.hardware.Camera.Parameters params = this.myCamera.getParameters();
            if (!params.getFocusMode().equals(android.hardware.Camera.Parameters.FOCUS_MODE_FIXED)) {
                this.myCamera.autoFocus(this.mAutoFocusListener);
            }
        }
        return true;
    }
}