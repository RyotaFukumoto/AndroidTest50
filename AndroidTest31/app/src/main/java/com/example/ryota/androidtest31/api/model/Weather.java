

package com.example.ryota.androidtest31.api.model;


import java.util.Collections;
import java.util.List;


public class Weather {
    private List<Forecast> forecasts;
    private Location location;
    private Description description;

    public List<Forecast> getForecasts() {
        return Collections.unmodifiableList(this.forecasts);
    }

    public Location getLocation() {
        return this.location;
    }

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