package com.example.ryota.androidtest04;


class Profile {
    private final String name;
    private final Integer age;
    private final String sex;
    private final String language;



    Profile(String name, Integer age, String sex, String language){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.language = language;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getSex() {
        return this.sex;
    }

    public String getLanguage() {
        return this.language;
    }
}
