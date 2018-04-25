package com.example.ryota.androidtest39;

import android.Manifest;
import android.Manifest.permission;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.ryota.androidtest39.R.id;
import com.example.ryota.androidtest39.R.layout;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private MyApplication app;

    private boolean mPermissionReady;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        this.imageView = (ImageView) findViewById(id.imageView);
        this.imageView.setClickable(true);
        findViewById(id.button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.this.mPermissionReady) {
                    startActivityForResult(new Intent(getApplication(), RecordActivity.class),1010);
                }
            }
        });


        int cameraPermission = ContextCompat.checkSelfPermission(this, permission.CAMERA);
        int storagePermission = ContextCompat.checkSelfPermission(this, permission.WRITE_EXTERNAL_STORAGE);
        this.mPermissionReady = cameraPermission == PackageManager.PERMISSION_GRANTED
                && storagePermission == PackageManager.PERMISSION_GRANTED;
        if (!this.mPermissionReady) {
            requirePermissions();
        }
    }

    private void requirePermissions() {
        ActivityCompat.requestPermissions(this, new String[]{permission.CAMERA,
                permission.WRITE_EXTERNAL_STORAGE}, 11);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Map<String, Integer> perm = new HashMap<>();
        perm.put(permission.CAMERA, PackageManager.PERMISSION_DENIED);
        perm.put(permission.WRITE_EXTERNAL_STORAGE, PackageManager.PERMISSION_DENIED);
        for (int i = 0; i < permissions.length; i++) {
            perm.put(permissions[i], grantResults[i]);
        }
        if (perm.get(permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                && perm.get(permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            this.mPermissionReady = true;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case (1010):

                this.app = (MyApplication) getApplication();
                Bitmap image = this.app.getObj();
                this.imageView.setImageBitmap(image);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.app.clearObj();
    }
}