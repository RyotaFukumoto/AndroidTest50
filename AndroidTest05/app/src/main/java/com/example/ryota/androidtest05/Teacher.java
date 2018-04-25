package com.example.ryota.androidtest05;

class Teacher {
    private  String name;
    private  int age;
    private  boolean sex;
    private  double salary;

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

    boolean getSex() {
        return this.sex;
    }

    double getSalary() {
        return this.salary;
    }
}
