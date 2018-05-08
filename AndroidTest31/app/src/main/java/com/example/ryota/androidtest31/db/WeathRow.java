package com.example.ryota.androidtest31.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.ryota.androidtest31.api.model.Image;

import java.net.URL;
@Entity
public class WeathRow {
    @PrimaryKey
    @NonNull
    private String day;

    private String image;

    private String weather;
    private String max;
    private String min;

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
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
