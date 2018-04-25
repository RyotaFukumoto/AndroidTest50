package com.example.ryota.androidtest06;

class Programmer extends Employee {
    private static final char A = 'A';
    private static final char B = 'B';
    private static final char C = 'C';
    private final Integer numberOfProjects;
    private final char rank;
    Programmer(String name, Integer age, Boolean sex, String address, Double salary, Integer numberOfProjects, char rank) {
        super(name, age, sex, address, salary);
        this.numberOfProjects = numberOfProjects;
        this.rank = rank;
    }

    @Override
    Double computeYearlyPay() {
        return getSalary() + (double) (10000 * this.numberOfProjects) + getBonusByRank();

    }

    private double getBonusByRank(){
        switch (this.rank){
            case A:
                 return 100000.0;
            case B:
                return 70000.0;
            case C:
                return 40000.0;
            default:
                return 0.0;
        }

    }
}
