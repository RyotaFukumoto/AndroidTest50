package com.example.ryota.androidtest31.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public  interface Weath_DAO {
    @Query("SELECT * FROM WeathRow")
    List<WeathRow> getAll();

    @Insert
    void  insert(WeathRow... weathRows);

    @Query("SELECT * FROM WeathRow WHERE day IN (:selectDay)")
    WeathRow loadAllByIds(String  selectDay);
}
