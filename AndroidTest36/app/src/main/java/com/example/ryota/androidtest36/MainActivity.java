package com.example.ryota.androidtest36;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;

import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;

import java.io.File;
import java.io.InputStream;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (TwitterCore.getInstance().getSessionManager().getActiveSession() == null) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(MainActivity.this, "ログイン中", Toast.LENGTH_LONG);
            toast.show();
        }

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File myImageFile = new File("/storage/self/primary/sample.jpg");
                Uri myImageUri = Uri.fromFile(myImageFile);

                TweetComposer.Builder builder = new TweetComposer.Builder(MainActivity.this)
                        .text("just setting up my Twitter Kit.");
//                        .image(myImageUri);
                builder.show();
            }
        });

    }

}
