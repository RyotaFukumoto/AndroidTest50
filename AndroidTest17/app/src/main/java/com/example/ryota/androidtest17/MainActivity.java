package com.example.ryota.androidtest17;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView = findViewById(R.id.textView2);

        this.textView.setClickable(true);
        this.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minut) {
                                Toast.makeText(MainActivity.this,
                                        String.valueOf(hourOfDay) + " : " + String.valueOf(minut),Toast.LENGTH_SHORT).show();
                                MainActivity.this.textView.setText(String.valueOf(hourOfDay) + " : " + String.valueOf(minut));
                            }
                        },hour,minute,true);
                timePickerDialog.show();
            }


        });
    }
}