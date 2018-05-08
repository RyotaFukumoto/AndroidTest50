package com.example.ryota.androidtest26;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DatabaseInsertActivity extends AppCompatActivity {

    private int getint;
    private EditText titleEditText;
    private EditText contentEditText;
    private TextView textView;
    private SQLiteDatabase db;
    private DateFormater dateFormater;
    private int count;
    private RecyclerAdapter adapter;
    private MainActivity mainActivity;
    public List<RowData> getTodoList() {
        return todoList;
    }

    private List<RowData> todoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_new_todo);
        this.dateFormater = new DateFormater();

        this.titleEditText = findViewById(R.id.editText2);
        this.contentEditText = findViewById(R.id.editText4);
        this.textView = findViewById(R.id.textView);
        this.textView.setText(String.valueOf(this.dateFormater.getLimitDateFrom(this.dateFormater.getNowDate())));
        final Button registerButton = (Button) findViewById(R.id.button);
        mainActivity = new MainActivity();
        registerButton.setEnabled(false);
        titleEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count != 0) {
                    registerButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        final Intent intent = getIntent();


            this.getint = intent.getIntExtra("id", 0);
            if (this.count != 0) {
                registerButton.setText("更新");
                CharSequence charSequence = intent.getCharSequenceExtra("title");
                CharSequence charSequence1 = intent.getCharSequenceExtra("content");

                String created = (String) intent.getCharSequenceExtra("created");
                String str = (String) intent.getCharSequenceExtra("limit");

                this.titleEditText.setText(charSequence);
                this.contentEditText.setText(charSequence1);
                CharSequence charSequence3 = str.replace("-", "/");
                this.textView.setText(charSequence3);

            }


            this.textView.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(DatabaseInsertActivity.this.dateFormater.getNow());
                            calendar.add(Calendar.DATE, 7);
                            DatePickerDialog datePickerDialog = new DatePickerDialog(DatabaseInsertActivity.this, new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


                                    DatabaseInsertActivity.this.textView.setText(String.format("%d/%02d/%02d", year, month + 1, dayOfMonth));
                                }
                            },
                                    calendar.get(Calendar.YEAR),
                                    calendar.get(Calendar.MONTH),
                                    calendar.get(Calendar.DATE)
                            );

                            //dialogを表示
                            datePickerDialog.show();
                        }
                    });




        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper = new DatabaseHelper(getApplication());
                DatabaseInsertActivity.this.db = databaseHelper.getWritableDatabase();
                if (DatabaseInsertActivity.this.getint == 0) {
                   dbInserter();
                }else {
                    dbUpdate();
                }
            }
        });
    }

    private void  dbInserter(){
        String created = this.dateFormater.getNowDate();
        String limited = this.dateFormater.getLimitDateFrom(created);

        ContentValues contentValues = new ContentValues();
        contentValues.put("todo_title", this.titleEditText.getText().toString());
        contentValues.put("todo_contents", this.contentEditText.getText().toString());
        contentValues.put("created", created);
        contentValues.put("limit_date", this.textView.getText().toString());
        contentValues.put("delete_flg", 0);
        long ret;

        try {
            String id = String.valueOf(DatabaseInsertActivity.this.getint);
            ret = this.db.insert(MainActivity.TR_TODO, null, contentValues);
        } finally {
            this.db.close();
        }

        if (ret == -1L) {
            Toast.makeText(getApplication(), "Insert失敗", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplication(), "Insert成功", Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    private void dbUpdate(){
        String modified = this.dateFormater.getNowDate();
        ContentValues contentValues = new ContentValues();
        contentValues.put("todo_title", this.titleEditText.getText().toString());
        contentValues.put("todo_contents", this.contentEditText.getText().toString());
        contentValues.put("modified", modified);
        contentValues.put("limit_date", this.textView.getText().toString());
        long ret;

        try {
            String id = String.valueOf(DatabaseInsertActivity.this.getint);
            ret = this.db.update(MainActivity.TR_TODO, contentValues, "todo_id = " + DatabaseInsertActivity.this.getint, null);
            Log.i("AlertDialog3", String.valueOf(ret));
        }finally {
            this.db.close();
        }
        if (ret == -1L) {
            Toast.makeText(getApplication(), "Insert失敗", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplication(), "Insert成功", Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    public List<RowData> reading(SQLiteDatabase db) {

        this.todoList = new ArrayList<>();


        try {
            String sql = "select * from " + "tr_todo where " + "delete_flg" + " = 0" +
                    " order by limit_date" + " asc ";
            Cursor cursor = db.rawQuery(sql, null);
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
        return todoList;

    }


}
