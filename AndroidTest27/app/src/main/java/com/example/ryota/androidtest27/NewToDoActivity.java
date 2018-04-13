package com.example.ryota.androidtest26;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewToDoActivity extends AppCompatActivity{
    private TextView textView;
    private EditText titleText;
    private EditText contentText;
    private Date now;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activit_new_todo);

        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        final SQLiteDatabase db = databaseHelper.getWritableDatabase();

        final ContentValues cv = new ContentValues();

        Button button = findViewById(R.id.button);
        this.textView = findViewById(R.id.textView);
        this.titleText = findViewById(R.id.editText2);
        this.contentText = findViewById(R.id.editText4);


        this.now = new Date(System.currentTimeMillis());


        this.textView.setText(dateFormat(sevenAdd(this.now)));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(NewToDoActivity.this.titleText.length()>0) {

                    cv.put("todo_title", String.valueOf(NewToDoActivity.this.titleText.getText()));
                    cv.put("todo_contents",String.valueOf(NewToDoActivity.this.contentText.getText()));
                    cv.put("limit_date",String.valueOf(NewToDoActivity.this.textView.getText()));
                    cv.put("created",String.valueOf(dateFormat(NewToDoActivity.this.now)));
                    try {
                        db.insert("tr_todo",null,cv);
                        finish();
                    }finally {
                        db.close();
                    }

                }
            }
        });
        this.textView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                NewToDoActivity.this.onClick(this);
            }
        });

    }
    private Date sevenAdd(Date date){
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        calendar.add(Calendar.DATE,7);
        return calendar.getTime();
    }
    private String dateFormat(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        return format.format(date);
    }



    private void onClick(View.OnClickListener v) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.now);
        calendar.add(Calendar.DATE,7);
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        //setした日付を取得して表示

                        NewToDoActivity.this.textView.setText(String.format("%d年%02d月%02d日", year, month+1, dayOfMonth));
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE)
        );

        //dialogを表示
        datePickerDialog.show();

    }
}
