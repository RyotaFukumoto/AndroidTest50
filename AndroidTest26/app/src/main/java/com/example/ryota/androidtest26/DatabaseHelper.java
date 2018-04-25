package com.example.ryota.androidtest26;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE ="CREATE TABLE tr_todo("
            + "todo_id INTEGER PRIMARY KEY AUTOINCREMENT," + "todo_title TEXT,"
            + "todo_contents TEXT," + "created TEXT," + "modified TEXT,"
            + "limit_date TEXT," + "delete_flg INTEGER" + ')';


    DatabaseHelper(Context context) {
        super(context, "tr_todo", null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
