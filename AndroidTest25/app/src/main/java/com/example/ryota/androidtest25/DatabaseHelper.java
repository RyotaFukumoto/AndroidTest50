package com.example.ryota.androidtest25;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "tr_todo";
    private static final String CREATE_TABLE ="CREATE TABLE emp("
            + "todo_id INTEGER PRIMARY KEY AUTOINCREMENT," + "todo_title TEXT,"
            + "todo_contents TEXT," + "created TEXT," + "modified TEXT,"
            + "limit_date TEXT," + "delete_flg INTEGER" + ")";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

       Log.d("db", db.getPath());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
