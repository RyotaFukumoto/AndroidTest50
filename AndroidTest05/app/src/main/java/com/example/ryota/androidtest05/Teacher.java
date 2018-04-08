package com.example.ryota.androidtest05;

class Teacher {
    private final String name;
    private final int age;
    private final boolean sex;
    private final double salary;

    Teacher(String name,int age,boolean sex,double salary){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }

    String getName() {
        return this.name;
    }

    int getAge() {
        return this.age;
    }

    Boolean getSex() {
        return this.sex;
    }

    Double getSalary() {
        return this.salary;
    }
}
