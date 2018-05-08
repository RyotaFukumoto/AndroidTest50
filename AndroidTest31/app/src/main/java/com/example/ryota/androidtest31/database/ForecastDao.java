package com.example.ryota.androidtest31.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ryota.androidtest31.api.model.Forecast;

import java.util.List;


@Dao
public interface ForecastDao {

    @Query("SELECT * FROM forecast ORDER BY date")
    List<Forecast> getNewest();

    @Insert
    void insertEntity(Forecast forecastEntity);

    @Query("DELETE FROM forecast")
    void deleteALL();

}
