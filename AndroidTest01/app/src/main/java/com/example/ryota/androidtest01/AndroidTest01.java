package com.example.ryota.androidtest01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class AndroidTest01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_test01);

        Boolean bool = true;
        String text = "abcd";
        int number = 1234;
        double dobl = 12.34;

        Log.d("LogOutPut","Boolean = " + bool);
        Log.d("LogOutPut", "String = " + text);
        Log.d("LogOutPut", "ing = " + number);
        Log.d("LogOutPut", "double = " + dobl);

    }
}
