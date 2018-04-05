package com.example.ryota.androidtest05;

import android.util.Log;

class FiveYearTeacher extends Teacher{

    FiveYearTeacher(String name, Integer age, Boolean sex, Double salary) {
        super(name, age, sex, salary );
    }
    public void calculateSalary() {
        Double sala = getSalary() * 1.1;
        Log.i("FiveYearTeasher","5年目の　" + getName() + " さんは " + sala + " 円です");
    }
}
