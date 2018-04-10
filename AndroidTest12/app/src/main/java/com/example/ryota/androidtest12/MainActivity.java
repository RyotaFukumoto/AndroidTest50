package com.example.ryota.androidtest12;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.ryota.androidtest12.ConnectionReceiver.Observer;
import com.example.ryota.androidtest12.R.id;
import com.example.ryota.androidtest12.R.layout;

public class MainActivity extends AppCompatActivity implements Observer {
    /**
     *
     */
    private WebView webView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);


        this.webView = findViewById(id.web_view);

        Button button1 = findViewById(id.button1);
        Button button2 = findViewById(id.button2);
        Button button3 = findViewById(id.button3);


        this.webView.loadUrl("https://www.google.co.jp/");

        this.webView.setWebViewClient(new WebViewClient());
        this.webView.getSettings().setJavaScriptEnabled(true);

        this.webView.getSettings().setDomStorageEnabled(true);

        getWindow().setFlags(
                LayoutParams.FLAG_HARDWARE_ACCELERATED,
                LayoutParams.FLAG_HARDWARE_ACCELERATED);


        button1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(MainActivity.this.webView.canGoBack()){
                    MainActivity.this.webView.goBack();
                }

            }
        });
        button2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                MainActivity.this.webView.reload();
            }
        });
        button3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(MainActivity.this.webView.canGoForward()) {
                    MainActivity.this.webView.goForward();
                }

            }
        });

    }


    @Override
    public void onConnect() {
        this.webView.reload();
    }

    @Override
    public void onDisconnect() {

        Log.i("オフライン","オフラインです。");
    }
}
