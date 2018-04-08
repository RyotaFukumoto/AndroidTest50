package com.example.ryota.androidtest01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Test01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(layout.activity_android_test01);
        boolean bol = false;
        Log.d("LogOutPut1","Boolean = " + bol);
        String text = "abcd";
        Log.d("LogOutPut2", "String = " + text);
        int number = 1234;
        Log.d("LogOutPut3", "ing = " + number);
        double dobl = 12.34;
        Log.d("LogOutPut4", "double = " + dobl);
    }
}
