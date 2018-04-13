package com.example.ryota.androidtest26;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> todo = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        FloatingActionButton button = findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),NewToDoActivity.class);
                startActivity(intent);

            }
        });

        ;


        Cursor cursor = db.query("tr_todo",new String[]{"todo_id", "todo_title","limit_contents"},null,null,null,null,"todo_contents DESC");
        boolean isEof = cursor.moveToFirst();
        while (isEof) {
            Log.d("dboutput","" +cursor.getInt(cursor.getColumnIndex("todo_title")) );
            int todo_title = cursor.getColumnIndex("todo_title");
            int limit_contents = cursor.getColumnIndex("limit_contents");
            String titlte = cursor.getString(todo_title);
            String limit = cursor.getString(limit_contents);
            todo.add(titlte + limit);
            isEof = cursor.moveToNext();
        }


    }
}
