package com.example.ryota.androidtest06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final char A = 'A';
    private static final char B = 'B';
    private static final char C = 'C';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Designer designer1 = new Designer("taro",24,true,"aaaaa",
                123.45,4);

        Double total1 = designer1.computeYearlyPay();
        Designer designer2 = new Designer("kojiro",23,false,"cccc",
                123.5,3);
        Log.i("Total1"," " + total1);
        Double total2 = designer2.computeYearlyPay();
        Log.i("Total2"," " + total2);
        Programmer programmer1 = new Programmer("hanako",25,false,"xxxxx",234.6,4,A);
        Double total3 = programmer1.computeYearlyPay();
        Programmer programmer2 = new Programmer("wakako",26,true,"vvvvv",234.56,5,C);
        Double total4 = programmer2.computeYearlyPay();
        Log.i("Total3"," " + total3);
        Log.i("Total4"," " + total4);

    }
}
