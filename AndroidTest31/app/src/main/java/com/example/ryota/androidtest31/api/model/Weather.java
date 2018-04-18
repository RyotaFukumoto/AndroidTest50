

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

    public Weather(List<Forecast> forecasts, Location location) {
        this.forecasts = forecasts;
        this.location = location;
    }

    public List<Forecast> getForecasts() {
        return this.forecasts;
    }

    public Location getLocation() {
        return this.location;
    }
}
