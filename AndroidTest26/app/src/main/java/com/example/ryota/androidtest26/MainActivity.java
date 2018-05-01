package com.example.ryota.androidtest26;

import android.content.Intent;
<<<<<<< HEAD
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
=======
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
public class MainActivity extends AppCompatActivity implements RowOnClickedListener{
    public static final String DELETE_FLG = "delete_flg";
    private RecyclerAdapter adapter;
>>>>>>> AndroidTest28
=======
public class MainActivity extends AppCompatActivity {
    private CasarealRecycleViewAdapter adapter;
>>>>>>> AndroidTest27

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        databaseHelper.getWritableDatabase();

        FloatingActionButton button = findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),NewToDoActivity.class);
                startActivity(intent);
            }
        });
=======

        RecyclerView rv = findViewById(R.id.casarealRecyclerView);
        //adapter = new RecyclerAdapter(this,todoList);

<<<<<<< HEAD
        this.adapter = new RecyclerAdapter(this, this);
=======
        RecyclerView rv = (RecyclerView) findViewById(R.id.casarealRecyclerView);
        this.adapter = new CasarealRecycleViewAdapter();
>>>>>>> AndroidTest27

        LinearLayoutManager llm = new LinearLayoutManager(this);

        rv.addItemDecoration(new DividerItemDecoration(this));

        rv.setHasFixedSize(true);

        rv.setLayoutManager(llm);

        rv.setAdapter(this.adapter);
<<<<<<< HEAD


=======
>>>>>>> AndroidTest27

        FloatingActionButton addButton = findViewById(R.id.floatingActionButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DatabaseInsertActivity.class);
                startActivity(intent);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onResume() {
        super.onResume();
        List<RowData> todoList = new ArrayList<>();
        //rawQueryメソッドでデータを取得
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        try (SQLiteDatabase db = dbHelper.getReadableDatabase()) {
<<<<<<< HEAD
            String sql = "select * from " + "tr_todo where " + DELETE_FLG + " = 0" +
=======
            String sql = "select * from " + "tr_todo where " + "delete_flg" + " = 0" +
>>>>>>> AndroidTest27
                    " order by limit_date" + " asc ";
            Cursor cursor = db.rawQuery(sql, null);
            //TextViewに表示
            while (cursor.moveToNext()) {
                int todoID = cursor.getInt(0);
                String title = cursor.getString(1);
                String content = cursor.getString(2);
                String limit = cursor.getString(5);

                RowData todo = new RowData(todoID, title, content, limit);
                todoList.add(todo);
            }
            Log.i("System.out", "");
        }
        this.adapter.setList(todoList);
        this.adapter.notifyDataSetChanged();
<<<<<<< HEAD
    }


    @Override
    public void rowClicked(RowData todoData) {

        Intent intent = new Intent(this, DatabaseInsertActivity.class);
        intent.putExtra("id",todoData.getTodoID());
        intent.putExtra("title",todoData.getTitle());
        intent.putExtra("content",todoData.getContent());
        intent.putExtra(DatabaseInsertActivity.CREATED,todoData.getCreated());
        intent.putExtra("limit",todoData.getLimit());

        startActivity(intent);
>>>>>>> AndroidTest28
=======
>>>>>>> AndroidTest27
    }
}
