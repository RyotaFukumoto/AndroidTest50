package com.example.ryota.androidtest47;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        // データの受信
        Map<String, String> data        = remoteMessage.getData();
        String id             = "";
        String label        = "";
        String text         = "";
        if (data.containsKey("id")){
            String  = data.get("id");
        }
        if (data.containsKey("label") ){ label = data.get("label");  }
        if (data.containsKey("text") ){ text = data.get("text");  }

        // 通知の作成
        NotificationCompat.Builder builder  = new NotificationCompat.Builder(getApplicationContext());
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("".equals(label)?getString(R.string.app_name):label);
        builder.setContentText(text);
        builder.setWhen(System.currentTimeMillis());
        builder.setDefaults(Notification.DEFAULT_SOUND
                | Notification.DEFAULT_VIBRATE
                | Notification.DEFAULT_LIGHTS);
        builder.setAutoCancel(true);

        // タッチ時、自アプリを起動する
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // 通知の表示
        NotificationManagerCompat manager = NotificationManagerCompat.from(getApplicationContext());
        manager.notify(1, builder.build());
    }
}

