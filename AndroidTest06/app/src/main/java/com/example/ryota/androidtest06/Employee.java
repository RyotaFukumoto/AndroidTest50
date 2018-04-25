package com.example.ryota.androidtest06;

 abstract class Employee {
    private final String name;
    private final Integer age;
    private final Boolean sex;
    private final String address;
    private final Double salary;

     Employee(String name, Integer age, Boolean sex, String address, Double salary){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.salary = salary;
    }

    String getName() {
         return this.name;
    }
    Integer getAge(){
         return this.age;
    }
    Boolean getSex(){
         return this.sex;
    }
    String getAddress(){
         return this.address;
    }
    Double getSalary(){
        return this.salary;
    }



    abstract Double computeYearlyPay();
}
