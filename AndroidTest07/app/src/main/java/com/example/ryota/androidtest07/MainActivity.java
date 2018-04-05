package com.example.ryota.androidtest07;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity implements Result {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Math math = new Math(this);
        math.calculate(1,2);
    }


    @Override
    public void result(Integer resultValue) {
        String result = String.valueOf(resultValue);
        Log.i("add",result);
    }
}
