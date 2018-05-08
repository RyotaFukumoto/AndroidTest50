package com.example.ryota.androidtest31.api.model;

public class Temperature {
    public Max getMax() {
        return this.max;
    }

    public void setMax(Max max) {
        this.max = max;
    }

    public Min getMin() {
        return this.min;
    }

    public void setMin(Min min) {
        this.min = min;
    }

    public Max max;
    public Min min;
}
