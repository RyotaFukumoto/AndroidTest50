package com.example.ryota.androidtest14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements ImportFlag.onClickListener {

    Output output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (Output) getSupportFragmentManager().findFragmentById(R.id.outputFragment);

    }

    @Override
    public void onClick(String text) {
        output.setTextView(text);
    }
}
