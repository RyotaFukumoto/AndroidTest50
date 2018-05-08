package com.example.ryota.androidtest31.database;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.ryota.androidtest31.api.model.Description;
import com.example.ryota.androidtest31.api.model.Forecast;

@Database(entities = {Description.class,Forecast.class},version = 1,exportSchema = false)
@TypeConverters(Converter.class)
public abstract class ForecastDatabase extends RoomDatabase {
    public abstract DescriptionDao descriptionDao();
    public abstract ForecastDao forecastDao();
}
