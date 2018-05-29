package com.example.ryota.androidtest50;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Uri uri = getIntent().getData();
        if(uri != null) {
            String id = uri.getQueryParameter("id");
            String name = uri.getQueryParameter("name");
            TextView textId = findViewById(R.id.textView);
            TextView textName = findViewById(R.id.textView2);
            textId.setText(id);
            textName.setText(name);
        }
    }
}
