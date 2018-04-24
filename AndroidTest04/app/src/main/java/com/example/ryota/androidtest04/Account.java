package com.example.ryota.androidtest04;

import android.util.Log;


class Account {
    private String name;
    private int age;
    private String sex;
    private String language;



    Account(String name, int age, String sex, String language){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.language = language;
    }

    public  void ProfileOutPut(){
        switch (sex){
            case "男性":
                Log.i("Profile1", name +" 君は、" +
                        language + " が得意な " + age + " 歳です。");
                break;

            case "女性":
                Log.i("Profile2", name +" さんは、" +
                        language + " が得意な " + age + " 歳です。");
                break;
            default:
                Log.i ("Profile3","全て入力してくだい。");
        }
    }


}


