package com.example.ryota.androidtest05;

import android.util.Log;

class FiveYearTeacher extends Teacher{

    FiveYearTeacher(String name, int age, boolean sex, double salary) {
        super(name, age, sex, salary );
    }
    public void calculateSalary() {
        double sala = getSalary() * 1.1;
        Log.i("FiveYearTeasher","5年目の　" + getName() + " さんは " + sala + " 円です");
    }
}
