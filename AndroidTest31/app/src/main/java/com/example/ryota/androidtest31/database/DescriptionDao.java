package com.example.ryota.androidtest31.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.ryota.androidtest31.api.model.Description;

@Dao
public interface DescriptionDao {

    @Query("SELECT * FROM description")
    Description getNewest();

    @Insert
    void insertEntity(Description descriptionEntity);

    @Query("DELETE FROM description")
    void deleteALL();

}

