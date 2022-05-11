package com.example.exp_7_4514_notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "123";
    private static final String image_channel="image";
    private static final String REPLY_CHANNEL ="reply" ;
    private static final String music_channel="music";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannel1();
    }
    private void createNotificationChannel1() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "srujan channel";
            String description = "srujan channel description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    public void sample_notification(View view) {
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        NotificationManagerCompat myManager=NotificationManagerCompat.from(this);

        NotificationCompat.Builder myNotification=new NotificationCompat.Builder(this,CHANNEL_ID);
        myNotification.setContentTitle("1 new message");
        myNotification.setContentText("this is the information about notification 4514");
        myNotification.setSmallIcon(com.google.android.material.R.drawable.btn_checkbox_checked_mtrl);

        Intent it =new Intent(this,MainActivity.class);
        PendingIntent pd=PendingIntent.getActivity(this,1,it,0);
        myNotification.setContentIntent(pd);
        myNotification.setAutoCancel(true);

        myManager.notify(1, myNotification  .build());
        finish();
    }

    public void Image_notification(View view) {
        NotificationManagerCompat myManager =NotificationManagerCompat.from(this);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.vignan_logo);


        NotificationCompat.Builder image_noti=new NotificationCompat.Builder(this,CHANNEL_ID)
                .setAutoCancel(true)
                .setContentText("image context text")
                .setContentTitle("Image Notification")
                .setSmallIcon(R.drawable.itachi)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));
        Intent intent =new Intent(this,MainActivity.class);
        PendingIntent pd=PendingIntent.getActivity(this,2,intent,0);
        image_noti.setContentIntent(pd);
        image_noti.setAutoCancel(true);
        myManager.notify(2, image_noti.build());
        finish();
    }

    public void Reply_notification(View view) {
        NotificationManagerCompat myManager =NotificationManagerCompat.from(this);
        NotificationCompat.Builder  mynotification=new NotificationCompat.Builder(this,CHANNEL_ID)
                .setAutoCancel(true)
                .setContentText("this is reply context text")
                .setContentText("THis is content Title")
                .setSmallIcon(com.google.android.material.R.drawable.btn_checkbox_checked_mtrl);


    }

    public void Music_notification(View view) {
    }
}