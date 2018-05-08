

package com.example.ryota.androidtest31.api.model;


<<<<<<< HEAD
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
=======
import java.util.Collections;
import java.util.List;


public class Weather {
    private List<Forecast> forecasts;
    private Location location;
    private Description description;
>>>>>>> AndroidTest33

    public List<Forecast> getForecasts() {
        return Collections.unmodifiableList(this.forecasts);
    }

<<<<<<< HEAD
=======
    public Location getLocation() {
        return this.location;
    }

<<<<<<< HEAD
>>>>>>> AndroidTest35

}
=======
    public Description getDescription() {
        return this.description;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setDescription(Description description) {
        this.description = description;
    }
}
>>>>>>> AndroidTest33
