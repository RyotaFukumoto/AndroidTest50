package com.example.ryota.androidtest26;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
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
    public static final String CREATED = "created";

    private EditText titleEditText;
    private Button registerButton;

    private  DateFormat df;
    private int getint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activit_new_todo);
        this.df = new SimpleDateFormat("yyyy/MM/dd");

        this.titleEditText = findViewById(R.id.editText2);

        final EditText contentEditText = findViewById(R.id.editText4);
        final TextView textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(getLimitDateFrom(getNowDate())));
        this.registerButton = (Button) findViewById(R.id.button);
        this.registerButton.setEnabled(false);

        this.titleEditText.addTextChangedListener(this.watchHandler);


        Intent intent = getIntent();
        this.getint = intent.getIntExtra("id",0);
        if(this.getint !=0){
            this.registerButton.setText("更新");
            CharSequence charSequence = intent.getCharSequenceExtra("title");
            CharSequence charSequence1 = intent.getCharSequenceExtra("content");
            CharSequence charSequence3 = intent.getCharSequenceExtra("limit");
            String str = (String) charSequence3;

            this.titleEditText.setText(charSequence);
            contentEditText.setText(charSequence1);
            String change = str.replaceAll("-", "/");
            textView.setText(change);

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


        this.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper databaseHelper = new DatabaseHelper(getApplication());
                SQLiteDatabase db = databaseHelper.getWritableDatabase();

                String created = getNowDate();
                String limited = getLimitDateFrom(created);

                ContentValues contentValues = new ContentValues();
                contentValues.put("todo_title", DatabaseInsert.this.titleEditText.getText().toString());
                contentValues.put("todo_contents",contentEditText.getText().toString());
                contentValues.put(CREATED,created);
                contentValues.put("modified",created);
                contentValues.put("limit_date",textView.getText().toString());
                contentValues.put(MainActivity.DELETE_FLG,0);
                long ret;
                if (DatabaseInsert.this.getint == 0) {


                    try {
                        ret = db.insert(DatabaseHelper.DB_NAME, null, contentValues);
                    } finally {
                        db.close();
                    }
                } else {
                    try {
                        String id = String.valueOf(DatabaseInsert.this.getint);
                        ret = db.update(DatabaseHelper.DB_NAME, contentValues, "todo_id = " + DatabaseInsert.this.getint, null);
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
    private final TextWatcher watchHandler = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if(DatabaseInsert.this.titleEditText.length()>0){
                DatabaseInsert.this.registerButton.setEnabled(true);
            }else {
                DatabaseInsert.this.registerButton.setEnabled(false);
            }
        }
    };

    private  Date getNow(){
        return new Date(System.currentTimeMillis());
    }


    private String getNowDate(){

        Date date = new Date(System.currentTimeMillis());
        return this.df.format(date);
    }

    private String getLimitDateFrom(String dateStr){
        Calendar calendar = Calendar.getInstance();


        Date date = new Date(dateStr);
        calendar.setTime(date);
        calendar.add(Calendar.DATE,7);
        Date limitDate = new Date(calendar.getTimeInMillis());
        return this.df.format(limitDate);
    }
}
