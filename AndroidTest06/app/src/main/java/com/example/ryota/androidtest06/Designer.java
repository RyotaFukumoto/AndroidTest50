package com.example.ryota.androidtest06;

class Designer extends Employee {
    private final Integer numberOfProjects;
    Designer(String name, Integer age, Boolean sex, String address, Double salary,Integer numberOfProjects) {
        super(name, age, sex, address, salary);
        this.numberOfProjects = numberOfProjects;
    }

    @Override
    Double computeYearlyPay() {
        return getSalary() + (double) (10000 * this.numberOfProjects);
    }
}
