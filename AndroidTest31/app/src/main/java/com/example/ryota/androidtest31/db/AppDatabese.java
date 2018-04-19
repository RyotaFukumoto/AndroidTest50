package com.example.ryota.androidtest31.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
@Database(entities = {WeathRow.class},version = 1,exportSchema = false)
public abstract class AppDatabese extends RoomDatabase {
    public abstract Weath_DAO weath_dao();
}
