package com.example.ryota.androidtest36;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class LoginActivity extends AppCompatActivity {
    private TwitterLoginButton loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.loginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        this.loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls

                Toast toast = Toast.makeText(LoginActivity.this, "ログイン成功", Toast.LENGTH_LONG);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                toast.show();
            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure

                Toast toast = Toast.makeText(LoginActivity.this, "ログイン失敗", Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        this.loginButton.onActivityResult(requestCode, resultCode, data);
    }
}
