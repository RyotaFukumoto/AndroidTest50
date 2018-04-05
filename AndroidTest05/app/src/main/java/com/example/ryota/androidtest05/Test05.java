package com.example.ryota.androidtest05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Test05 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FiveYearTeacher fiveYearTeacher1  = new FiveYearTeacher("太郎",25,true,100.0);
        FiveYearTeacher fiveYearTeacher2 = new FiveYearTeacher("二郎",30,false,120.0);
        fiveYearTeacher1.calculateSalary();
        fiveYearTeacher2.calculateSalary();

        TenYearTeacher tenYearTeacher1 = new TenYearTeacher("太郎",25,true,100.0);
        TenYearTeacher tenYearTeacher2 = new TenYearTeacher("二郎",30,false,120.0);
        tenYearTeacher1.calculateSalary();
        tenYearTeacher2.calculateSalary();
    }
}
