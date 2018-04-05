package com.example.ryota.androidtest05;

class Teacher {
    private final String name;
    private final Integer age;
    private final Boolean sex;
    private final Double salary;

    Teacher(String name,Integer age,Boolean sex,Double salary){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }

    String getName() {
        return this.name;
    }

    Integer getAge() {
        return this.age;
    }

    Boolean getSex() {
        return this.sex;
    }

    Double getSalary() {
        return this.salary;
    }
}
