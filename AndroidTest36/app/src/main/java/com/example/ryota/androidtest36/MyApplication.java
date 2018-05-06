package com.example.ryota.androidtest36;

import android.app.Application;
import android.util.Log;

import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;

class MyApplication extends Application {
    private static final String CONSUMER_KEY = "BrQBtGdXUZVm4gzqf25K0CtUm";
    private static final String CONSUMER_SECRET = "iYO4WvYL0QUDwSdAgainxZy3WHNELkAsoWavA5ojjY0o14yYA1";


    @Override
    public void onCreate() {
        super.onCreate();

        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig(CONSUMER_KEY, CONSUMER_SECRET))
                .debug(true)
                .build();
        Twitter.initialize(config);
    }
}
