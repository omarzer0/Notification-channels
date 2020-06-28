package com.azapps.simplechannelnotification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    // here we define the channels so when the app starts it is created
    // define these constants where ever you see fits
    public static final String CHANNEL_1 ="channel1";
    public static final String CHANNEL_2 ="channel2";

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // create the 2 channels
            NotificationChannel channel1 = new NotificationChannel(CHANNEL_1,"Channel1", NotificationManager.IMPORTANCE_HIGH);
            // customize your channel
            channel1.setDescription("channel 1 test");
            channel1.enableVibration(true);

            NotificationChannel channel2 = new NotificationChannel(CHANNEL_2,"Channel2",NotificationManager.IMPORTANCE_LOW);
            channel2.setDescription("channel 2 test");

            // our channels are ready so use NotificationManager to create them
            // do not use new NotificationManager
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);

            // DO NOT FORGET TO Manifest android:name=".this class name"
        }

    }
}
