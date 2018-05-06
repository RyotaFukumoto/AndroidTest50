package com.example.ryota.androidtest31.database;

import com.example.ryota.androidtest31.api.model.Forecast;

import java.util.Collections;
import java.util.List;

public class ResponseData {
    private String description;
    private List<Forecast> forecastList;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Forecast> getForecastDataList() {
        return Collections.unmodifiableList(this.forecastList);
    }

    public void setForecastList(List<Forecast> forecastList) {
        this.forecastList = forecastList;
    }
}
