package com.example.ryota.androidtest26;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatabaseInsert extends AppCompatActivity {

    private String created;
    private int getint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_new_todo);



        final EditText titleEditText = findViewById(R.id.editText2);

        final EditText contentEditText = findViewById(R.id.editText4);
        final TextView textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(getLimitDateFrom(getNowDate())));
        Button registerButton = (Button) findViewById(R.id.button);


        final Intent intent = getIntent();
        getint = intent.getIntExtra("id",0);
        if(getint !=0){
            CharSequence charSequence = intent.getCharSequenceExtra("title");
            CharSequence charSequence1 = intent.getCharSequenceExtra("content");
            created = (String) intent.getCharSequenceExtra("created");
            CharSequence charSequence3 = intent.getCharSequenceExtra("limit");


            titleEditText.setText(charSequence);
            contentEditText.setText(charSequence1);
            textView.setText(charSequence3);

        }

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        textView.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(getNow());
                calendar.add(Calendar.DATE, 7);
                DatePickerDialog datePickerDialog = new DatePickerDialog(DatabaseInsert.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                //setした日付を取得して表示

                                textView.setText(String.format("%d/%02d/%02d", year, month + 1, dayOfMonth));
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
                SQLiteDatabase db = databaseHelper.getWritableDatabase();

                String created = getNowDate();
                String limited = getLimitDateFrom(created);

                ContentValues contentValues = new ContentValues();
                contentValues.put("todo_title",titleEditText.getText().toString());
                contentValues.put("todo_contents",contentEditText.getText().toString());
                contentValues.put("created",created);
                contentValues.put("modified",created);
                contentValues.put("limit_date",textView.getText().toString());
                contentValues.put("delete_flg",0);
                long ret;
                if(getint != 0){
                    try {
                        String id = String.valueOf(getint);
                        ret = db.update("tr_todo",contentValues,"todo_id = "+ getint,null);
                    }finally {
                        db.close();
                    }

                }else {


                    try {
                        ret = db.insert("tr_todo", null, contentValues);
                    } finally {
                        db.close();
                    }
                }
                if (ret == -1L) {
                    Toast.makeText(getApplication(), "Insert失敗", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplication(), "Insert成功", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }

    private  Date getNow(){
        Date date = new Date(System.currentTimeMillis());
        return date;
    }


    private String getNowDate(){
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date(System.currentTimeMillis());
        return df.format(date);
    }

    private String getLimitDateFrom(String dateStr){
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

        Date date = new Date(dateStr);
        calendar.setTime(date);
        calendar.add(Calendar.DATE,7);
        Date limitDate = new Date(calendar.getTimeInMillis());
        return df.format(limitDate);
    }
}
