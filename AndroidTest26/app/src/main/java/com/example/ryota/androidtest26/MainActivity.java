package com.example.ryota.androidtest26;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RowOnClickedListener,DialogListerer {
    public static final String TR_TODO = "tr_todo";
    private List<RowData> todoList;
    private RecyclerAdapter adapter;
    private int position;
    private RowData rowData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCreat();


        FloatingActionButton addButton = findViewById(R.id.floatingActionButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DatabaseInsertActivity.class);
                startActivity(intent);
            }
        });


    }

    private void recyclerViewCreat(){
        RecyclerView rv = findViewById(R.id.casarealRecyclerView);
        //adapter = new RecyclerAdapter(this,todoList);

        this.adapter = new RecyclerAdapter(this, this.todoList, this);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        rv.addItemDecoration(new DividerItemDecoration(this));

        rv.setHasFixedSize(true);

        rv.setLayoutManager(llm);

        rv.setAdapter(this.adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.todoList = new ArrayList<>();
        //rawQueryメソッドでデータを取得
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try {
            String sql = "select * from " + "tr_todo where " + "delete_flg" + " = 0" +
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
        } finally {
            db.close();
        }
        this.adapter.setList(this.todoList);
        this.adapter.notifyDataSetChanged();
    }




    public void rowClicked(RowData todoData) {

        Intent intent = new Intent(MainActivity.this, DatabaseInsertActivity.class );
        intent.putExtra("id",todoData.getTodoID());
        intent.putExtra("title",todoData.getTitle());
        intent.putExtra("content",todoData.getContent());
        intent.putExtra("created",todoData.getCreated());
        intent.putExtra("modified",todoData.getModified());
        intent.putExtra("limit",todoData.getLimit());
        intent.putExtra("delete",todoData.getDelete_flg());

        startActivity(intent);
    }

    @Override
    public void rowLongClicked(RowData todoData) {
        this.rowData = todoData;
        DeleteflgDialogFragment deleteflgDialogFragment = new DeleteflgDialogFragment();
        deleteflgDialogFragment.setDialogListener(this);
        deleteflgDialogFragment.show(getFragmentManager(),"delete");
    }


    @Override
    public void doPositiveClick() {
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplication());
        ContentValues contentValues = new ContentValues();
        int id = this.rowData.getTodoID();
        contentValues.put("todo_id",id);
        contentValues.put("delete_flg", "1");
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        try {
            long ret = db.update(TR_TODO, contentValues, "todo_id = " + id, null);
        } finally {
            db.close();
        }
        onResume();

    }
}
