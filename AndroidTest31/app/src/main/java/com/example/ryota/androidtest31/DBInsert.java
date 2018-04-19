package com.example.ryota.androidtest31;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import com.example.ryota.androidtest31.db.AppDatabese;
import com.example.ryota.androidtest31.db.WeathRow;

import java.util.List;

public class DBInsert {
    private AppDatabese databese;
    private String DB_name = "test_db";

    public List<WeathRow> setDatabese(List<WeathRow> list, Context context){
        Log.d("db","setin");
        AppDatabese  appDatabese = Room.databaseBuilder(context,AppDatabese.class,DB_name).build();

        for(int i = 0;i< list.size();i++){

                appDatabese.weath_dao().insert(list.get(i));
                Log.d("db", String.valueOf(list.get(i)));

        }
        List<WeathRow> list1 = appDatabese.weath_dao().getAll();
        return list1;

    }


}
