

package com.example.ryota.androidtest31.api.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * An Gson class for Weather
 */
public class Weather {
    @SerializedName("forecasts")
    public List<Forecast> forecasts;
    @SerializedName("location")
    public Location location;
    @SerializedName("description")
    public Description description;

    public Weather(List<Forecast> forecasts, Location location,Description description) {
        this.forecasts = forecasts;
        this.location = location;
        this.description = description;
    }

    public List<Forecast> getForecasts() {
        return this.forecasts;
    }

    public Location getLocation() {
        return this.location;
    }

    public Description getDescription() {
        return this.description;
    }
}
