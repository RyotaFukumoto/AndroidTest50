package com.example.ryota.androidtest26;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RowOnClickedListener,DialogListener{
    private List<RowData> todoList;
    private RecyclerAdapter adapter;
    private RecyclerView rv;
    private int position;
    private RowData rowData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rv = findViewById(R.id.casarealRecyclerView);
        //adapter = new RecyclerAdapter(this,todoList);

        adapter = new RecyclerAdapter(this, todoList, this);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        rv.addItemDecoration(new DividerItemDecoration(this));

        rv.setHasFixedSize(true);

        rv.setLayoutManager(llm);

        rv.setAdapter(adapter);


        FloatingActionButton addButton = findViewById(R.id.floatingActionButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DatabaseInsert.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        todoList = new ArrayList<>();
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

                RowData todo = new RowData(todoID,title,content,limit);

                todoList.add(todo);
            }
        } finally {
            db.close();
        }
        adapter.setList(todoList);
        adapter.notifyDataSetChanged();
    }




    public void rowClicked(RowData todoData) {

        Intent intent = new Intent(MainActivity.this, DatabaseInsert.class );
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
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        int id = rowData.getTodoID();
        contentValues.put("todo_id",id);
        contentValues.put("delete_flg", "1");
        long ret;
        try{
            ret = db.update("tr_todo",contentValues,"todo_id = " + id,null);
        }finally {
            db.close();
        }
        onResume();

    }
}
