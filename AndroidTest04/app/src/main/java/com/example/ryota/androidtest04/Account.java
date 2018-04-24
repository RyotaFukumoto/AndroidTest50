package com.example.ryota.androidtest04;

import android.util.Log;


class Account {
    private String name;
    private int age;
    private String sex;

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getSex() {
        return this.sex;
    }

    public String getLanguage() {
        return this.language;
    }

    private String language;



    Account(String name, int age, String sex, String language){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.language = language;

    }





}


