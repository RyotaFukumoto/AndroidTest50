package com.example.ryota.androidtest10;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.security.SecureRandom;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView = findViewById(R.id.imageView);
        @SuppressLint("Recycle") final TypedArray typedArray = getApplicationContext().getResources().obtainTypedArray(R.array.random_background);
        final SecureRandom r = new SecureRandom();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = r.nextInt(4) + 1;
                Drawable drawable = typedArray.getDrawable(n);
                imageView.setImageDrawable(drawable);
            }
        });
    }
}
