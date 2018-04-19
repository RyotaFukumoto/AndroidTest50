package com.example.ryota.androidtest31;

import android.graphics.drawable.Drawable;
import android.util.Log;

import com.example.ryota.androidtest31.api.model.Image;

import java.net.URL;

public class WeathRow {

    private String image;
    private String day;
    private String weather;
    private String max;
    private String min;

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        Log.d("URL", image);
        this.image = image;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getWeather() {
        return this.weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getMax() {
        return this.max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return this.min;
    }

    public void setMin(String min) {
        this.min = min;
    }
}
