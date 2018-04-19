package com.example.ryota.androidtest31;

import com.example.ryota.androidtest31.api.model.Weather;
import com.example.ryota.androidtest31.db.WeathRow;

import java.util.List;

interface WeatherViewListener {
    void ViewReload(List<WeathRow> list);
}
