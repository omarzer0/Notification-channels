package com.azapps.simplechannelnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.azapps.simplechannelnotification.App.CHANNEL_1;
import static com.azapps.simplechannelnotification.App.CHANNEL_2;

public class MainActivity extends AppCompatActivity {
    // this is a wrapper for NotificationManager with extra features like checks for compatibility
    private NotificationManagerCompat notificationManager;
    private EditText edTitle , edDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init the NotificationManagerCompat that we actually use to send notification
        notificationManager = NotificationManagerCompat.from(this);

        edTitle = findViewById(R.id.edit_text_title);
        edDescription = findViewById(R.id.edit_text_description);
    }

    public void sendOnChannel1(View view) {
        String title = edTitle.getText().toString();
        String description = edDescription.getText().toString();
        // create the notification
        // USE new NotificationCompat.Builder NOT new notification
        Notification notification1 = new NotificationCompat.Builder(this,CHANNEL_1)
                .setSmallIcon(R.drawable.ic_baseline_looks_one_24)
                .setContentTitle(title)
                .setContentText(description)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        // our notification is ready now we can use it
        notificationManager.notify(1, notification1);
    }

    public void sendOnChannel2(View view) {

        String title = edTitle.getText().toString();
        String description = edDescription.getText().toString();
        // create the notification
        // USE new NotificationCompat.Builder NOT new notification
        Notification notification1 = new NotificationCompat.Builder(this,CHANNEL_2)
                .setSmallIcon(R.drawable.ic_baseline_looks_one_24)
                .setContentTitle(title)
                .setContentText(description)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        // our notification is ready now we can use it
        notificationManager.notify(2, notification1);
    }
}