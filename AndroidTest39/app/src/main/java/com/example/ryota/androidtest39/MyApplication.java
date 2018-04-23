package com.example.ryota.androidtest39;
import android.app.Activity;
import android.app.Application;
import android.graphics.Bitmap;

class MyApplication extends Application {
    private Bitmap obj;

    public void setObj(Bitmap bmp){
        this.obj = null;
        this.obj = bmp;
    }

    public Bitmap getObj(){
        return this.obj;
    }

    public void clearObj(){
        this.obj = null;
    }

}