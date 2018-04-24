package com.example.ryota.androidtest26;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity implements RowOnClickedListener{
    public static final String DELETE_FLG = "delete_flg";
    private List<RowData> todoList;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView rv = findViewById(R.id.casarealRecyclerView);
        //adapter = new RecyclerAdapter(this,todoList);

        this.adapter = new RecyclerAdapter(this, this.todoList, this);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        rv.addItemDecoration(new DividerItemDecoration(this));

        rv.setHasFixedSize(true);

        rv.setLayoutManager(llm);

        rv.setAdapter(this.adapter);



        FloatingActionButton addButton = findViewById(R.id.floatingActionButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DatabaseInsert.class);
                startActivity(intent);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onResume() {
        super.onResume();
        this.todoList = new ArrayList<>();
        //rawQueryメソッドでデータを取得
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        try (SQLiteDatabase db = dbHelper.getReadableDatabase()) {
            String sql = "select * from " + "tr_todo where " + DELETE_FLG + " = 0" +
                    " order by limit_date" + " asc ";
            Cursor cursor = db.rawQuery(sql, null);
            //TextViewに表示
            StringBuilder text = new StringBuilder();
            while (cursor.moveToNext()) {
                int todoID = cursor.getInt(0);
                String title = cursor.getString(1);
                String content = cursor.getString(2);
                String limit = cursor.getString(5);

                RowData todo = new RowData(todoID, title, content, limit);
                this.todoList.add(todo);
            }
            Log.i("System.out", text.toString());
        }
        this.adapter.setList(this.todoList);
        this.adapter.notifyDataSetChanged();
    }



    @Override
    public void rowClicked(RowData todoData) {

        Intent intent = new Intent(this, DatabaseInsert.class);
        intent.putExtra("id",todoData.getTodoID());
        intent.putExtra("title",todoData.getTitle());
        intent.putExtra("content",todoData.getContent());
        intent.putExtra(DatabaseInsert.CREATED,todoData.getCreated());
        intent.putExtra("limit",todoData.getLimit());

        startActivity(intent);
    }
}
