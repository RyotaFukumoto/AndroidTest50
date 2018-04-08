package com.example.ryota.androidtest04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


class Account {
    private  String name;
    private  int age;
    private  String sex;
    private  String language;



    Account(String name, int age, String sex, String language){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.language = language;
    }

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

    public  void ProfileOutPut(){
        switch (this.sex){
            case "男性":
                Log.i("Profile1", this.name +" 君は、" +
                        this.language + " が得意な " + this.age + " 歳です。");
                break;

            case "女性":
                Log.i("Profile2", this.name +" さんは、" +
                        this.language + " が得意な " + this.age + " 歳です。");
                break;
            default:
                Log.i ("Profile3","全て入力してくだい。");
        }
    }


}


