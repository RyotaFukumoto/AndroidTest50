

package com.example.ryota.androidtest31.api.model;


import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * An Gson class for Weather
 */
public class Weather {
    @SerializedName("forecasts")
    private List<Forecast> forecasts;


<<<<<<< HEAD
    public Weather(List<Forecast> forecasts) {
        this.forecasts = forecasts;
=======

    public Weather(List<Forecast> forecasts, Location location) {
        this.forecasts = forecasts;
        this.location = location;
>>>>>>> AndroidTest35

    }

    public List<Forecast> getForecasts() {
        return this.forecasts;
    }

<<<<<<< HEAD
=======
    public Location getLocation() {
        return this.location;
    }

>>>>>>> AndroidTest35

}
