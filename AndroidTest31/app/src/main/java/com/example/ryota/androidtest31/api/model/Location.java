package com.example.ryota.androidtest31.api.model;

import com.google.gson.annotations.SerializedName;

public class Location {
    @SerializedName("city")
    public String city;

    public Location(String city) {
        this.city = city;
    }

    public Location() {
    }


    public String getCity() {
        return this.city;
    }
}
