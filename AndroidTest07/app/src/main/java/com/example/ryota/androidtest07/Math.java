package com.example.ryota.androidtest07;

class Math {
    private final Result result;

    public void calculate(Integer A, Integer B) {
        Integer total = A + B;
        this.result.result(total);

    }
    Math(Result result){
        this.result = result;
    }
}



