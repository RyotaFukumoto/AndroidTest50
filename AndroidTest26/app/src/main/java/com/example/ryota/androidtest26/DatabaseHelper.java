package com.example.ryota.androidtest26;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DatabaseHelper extends SQLiteOpenHelper {
<<<<<<< HEAD
<<<<<<< HEAD
    private static final String DB_NAME = "tr_todo";
=======
    private static final int DATABASE_VERSION = 1;
    public static final String DB_NAME = "tr_todo";
>>>>>>> AndroidTest28
=======
    private static final int DATABASE_VERSION = 1;
>>>>>>> AndroidTest27
    private static final String CREATE_TABLE ="CREATE TABLE tr_todo("
            + "todo_id INTEGER PRIMARY KEY AUTOINCREMENT," + "todo_title TEXT,"
            + "todo_contents TEXT," + "created TEXT," + "modified TEXT,"
            + "limit_date TEXT," + "delete_flg INTEGER" + ')';


    DatabaseHelper(Context context) {
<<<<<<< HEAD
<<<<<<< HEAD
        super(context, DB_NAME, null, 1);
=======
        super(context, DB_NAME, null, DATABASE_VERSION);
>>>>>>> AndroidTest28
=======
        super(context, "tr_todo", null, DATABASE_VERSION);
>>>>>>> AndroidTest27
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}