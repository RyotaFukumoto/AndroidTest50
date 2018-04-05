package com.example.ryota.androidtest05;

import android.util.Log;

class TenYearTeacher extends Teacher {

    TenYearTeacher(String name, Integer age, Boolean sex, Double salary) {
        super(name, age, sex, salary );
    }
    public void calculateSalary() {
        Double sala = getSalary() * 1.3;
        Log.i("TenYearTeasher","10年目の　" + getName() + " さんは " + sala + " 円です");
    }
}
