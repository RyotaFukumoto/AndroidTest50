package com.example.ryota.androidtest36;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;

import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;


public class MainActivity extends AppCompatActivity {
    private static final String CONSUMER_KEY = "BrQBtGdXUZVm4gzqf25K0CtUm";
    private static final String CONSUMER_SECRET = "iYO4WvYL0QUDwSdAgainxZy3WHNELkAsoWavA5ojjY0o14yYA1";

    private TwitterLoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig(CONSUMER_KEY, CONSUMER_SECRET))
                .debug(true)
                .build();
        Twitter.initialize(config);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.loginButton = findViewById(R.id.login_button);
        this.loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                postActivity();
            }
            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
                Toast.makeText(getApplication(), "連携が必要です。", Toast.LENGTH_SHORT).show();
            }
        });
        TwitterCore.getInstance().getSessionManager().clearActiveSession();
    }

    private void postActivity() {
        Intent intent = new Intent(getApplication(), PostActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        this.loginButton.onActivityResult(requestCode, resultCode, data);
    }
}