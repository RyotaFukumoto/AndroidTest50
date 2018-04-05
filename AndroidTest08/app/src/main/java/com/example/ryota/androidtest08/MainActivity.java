package com.example.ryota.androidtest08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTextView((TextView) findViewById(R.id.textView));
        String str = (String) getTextView().getText();
        Log.i("Text",str);
    }

    private TextView getTextView() {
        return this.textView;
    }

    private void setTextView(TextView textView) {
        this.textView = textView;
    }
}
