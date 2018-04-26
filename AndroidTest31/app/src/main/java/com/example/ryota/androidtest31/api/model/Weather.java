

package com.example.ryota.androidtest31.api.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * An Gson class for Weather
 */
public class Weather {
    @SerializedName("forecasts")
    private List<Forecast> forecasts;


    public Weather(List<Forecast> forecasts) {
        this.forecasts = forecasts;

    }

    public List<Forecast> getForecasts() {
        return this.forecasts;
    }


}
