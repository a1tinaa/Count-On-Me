package com.example.countdowntoTHPTQG;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;

import java.util.Date;

import androidx.core.app.NotificationCompat;

//Class tạo thông báo cho app
public class NotificationReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        class NotificationHelper {

            private final Context mContext;
            private static final String NOTIFICATION_CHANNEL_ID = "10001";

            NotificationHelper(Context context) {
                mContext = context;
            }



            void createNotification()
            {
                Date now = new Date();
                long currTime = now.getTime(); //Trả về giá trị milliseconds của ngày hiện tại kể từ 1/1/1970, 00:00:00 GTM
                long dayLeft = (1624554000000L - currTime)/86400000; //1624554000000L: giá trị ms của ngày 25/06/2021 00:00:00; Kết quả nhận được sau phép tính là số ngày còn lại đến ngày 25/06/2021

                Intent intent = new Intent(mContext, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                PendingIntent resultPendingIntent = PendingIntent.getActivity(mContext,
                        0 /* Request code */, intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);


                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext, NOTIFICATION_CHANNEL_ID);
                mBuilder.setSmallIcon(R.drawable.ic_baseline_access_time_24);
                mBuilder.setContentTitle("Đếm ngược ngày thi THPTQG")
                        .setContentText("Còn " + dayLeft + " ngày")
                        .setAutoCancel(false)
                        .setColor(Color.BLUE)
                        .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                        .setContentIntent(resultPendingIntent);

                NotificationManager mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
                {
                    int importance = NotificationManager.IMPORTANCE_HIGH;
                    NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance);
                    notificationChannel.enableLights(true);
                    notificationChannel.setLightColor(Color.RED);
                    notificationChannel.enableVibration(true);
                    notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                    assert mNotificationManager != null;
                    mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
                    mNotificationManager.createNotificationChannel(notificationChannel);
                }
                assert mNotificationManager != null;
                mNotificationManager.notify(0 /* Request Code */, mBuilder.build());
            }
        }

        NotificationHelper notificationHelper = new NotificationHelper(context);
        notificationHelper.createNotification();

    }

}

