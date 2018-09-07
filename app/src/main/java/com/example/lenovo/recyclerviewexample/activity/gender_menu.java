package com.example.lenovo.recyclerviewexample.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lenovo.recyclerviewexample.R;

import javax.xml.transform.Result;

public class gender_menu extends AppCompatActivity {

    private String my_channel_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_menu);
        // ContactMenu button
        Button btnContactMenu = findViewById(R.id.btnContactGenderMenu);
        registerForContextMenu(btnContactMenu);
        // Notificationg button
        Button btnNotification = findViewById(R.id.btnNotification);
        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = gender_menu.this;
                Intent intent = new Intent(context, Result.class);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
                builder
                       .setContentTitle("ACB Mobile")
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.abc))
                        .setSmallIcon(R.drawable.abc)
                        .setContentText("New Event appear on your app")
                        .setTicker("Ticker");
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                int notificationId = (int) (System.currentTimeMillis()/1000);
                notificationManager.notify(notificationId,builder.build());
            }
        });

        // button Notification Link
        Button btnNotificationLink = findViewById(R.id.btnNotificationLink);
        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://facebook.com"));
                PendingIntent pendingIntent = PendingIntent.getActivity(gender_menu.this,1, intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                Uri defaultsoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),my_channel_01);

            builder
                .setContentTitle("New notification from facebook")
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.abc)
                .setSound(defaultsoundUri)
                .setPriority(Notification.PRIORITY_HIGH)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentInfo("Hello this is contentInfo")
                .setContentText("Someone sent you a friend request")
                    .setSubText("This is subText")
                    .setContentIntent(pendingIntent);
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                int notificationId = (int) (System.currentTimeMillis()%1000);
                notificationManager.notify(notificationId,builder.build());
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contact_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.male:
                Toast.makeText(this,"Male", Toast.LENGTH_SHORT).show();
                break;
            case R.id.female:
                Toast.makeText(this,"Feale", Toast.LENGTH_SHORT).show();
                break;
            case R.id.other:
                Toast.makeText(this,"Other", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
