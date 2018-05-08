package com.example.ryota.androidtest26;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DB_NAME = MainActivity.TR_TODO;
    private static final String CREATE_TABLE ="CREATE TABLE tr_todo("
            + "todo_id INTEGER PRIMARY KEY AUTOINCREMENT," + "todo_title TEXT,"
            + "todo_contents TEXT," + "created TEXT," + "modified TEXT,"
            + "limit_date TEXT," + "delete_flg INTEGER" + ')';
//    private static final  String SELECT_TABLE = "SELECT  t FROM Persons WHERE Name LIKE ? ORDER BY Id"

    DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
