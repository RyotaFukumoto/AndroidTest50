package com.example.ryota.androidtest26;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RowOnClickedListener,DialogListerer {
    public static final String TR_TODO = "tr_todo";
    private List<RowData> todoList;
    private RecyclerAdapter adapter;
    private int position;
    private RowData rowData;
    private DatabaseInsertActivity databaseInsertActivity;
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.databaseInsertActivity = new DatabaseInsertActivity();
        this.dbHelper = new DatabaseHelper(this);
        this.db = this.dbHelper.getReadableDatabase();
        recyclerViewCreat();
        callData();


        final FloatingActionButton addButton = findViewById(R.id.floatingActionButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, DatabaseInsertActivity.class);
                startActivity(intent);

            }
        });


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        this.db = this.dbHelper.getReadableDatabase();
        this.adapter.setList(this.databaseInsertActivity.reading(this.db));
        this.adapter.notifyDataSetChanged();

    }
    private void callData(){

        this.todoList = this.databaseInsertActivity.reading(this.db);
        this.adapter.setList(this.todoList);
        this.adapter.notifyDataSetChanged();
    }
    private void recyclerViewCreat(){
        RecyclerView rv = findViewById(R.id.casarealRecyclerView);

        this.adapter = new RecyclerAdapter(this, this.todoList, this);

        LinearLayoutManager llm = new LinearLayoutManager(this);

        rv.addItemDecoration(new DividerItemDecoration(this));

        rv.setHasFixedSize(true);

        rv.setLayoutManager(llm);

        rv.setAdapter(this.adapter);

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
        Log.d("intent", String.valueOf(todoData.getTitle()));
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
        this.db = this.dbHelper.getReadableDatabase();
        this.databaseInsertActivity.delete(this.rowData.getTodoID(),getApplicationContext());

//        contentValues.put("todo_id",id);
//        contentValues.put("delete_flg", "1");
//        SQLiteDatabase dbset = databaseHelper.getWritableDatabase();
//        try {
//            long ret = dbset.update(TR_TODO, contentValues, "todo_id = " + id, null);
//            todoList = databaseInsertActivity.reading(db);
//        } finally {
//            dbset.close();
//        }

        this.todoList = this.databaseInsertActivity.reading(this.db);
        this.adapter.setList(this.todoList);
        this.adapter.notifyDataSetChanged();
        
    }

}
