package com.example.ryota.androidtest12;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionReceiver extends BroadcastReceiver {
    private final Observer mObserver;

    public ConnectionReceiver(Observer observer) {
        super();
        this.mObserver = observer;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info == null) {
            this.mObserver.onDisconnect();
        }else {
           this.mObserver.onConnect();
        }
    }

    //----- コールバックを定義 -----
    interface Observer {
        void onConnect();
        void onDisconnect();
    }
}