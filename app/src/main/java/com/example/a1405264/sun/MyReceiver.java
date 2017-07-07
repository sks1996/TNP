package com.example.a1405264.sun;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

public class MyReceiver extends BroadcastReceiver {

    NotificationCompat.Builder notification;
    private static final int UNIQUE_ID=123476776;
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.



        if(intent.getAction().equals("A_NEW_NOTIFICATION"))
        {
         /*   Intent Intent = new Intent(context, Notification.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0 /* Request code , intent,
                    PendingIntent.FLAG_ONE_SHOT);




            Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                    .setSmallIcon(R.drawable.notify)
                    .setContentTitle("TNP")
                    .setAutoCancel(true)
                    .setContentText(MainActivity.VALUE)
                    .setColor(0)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent);


            NotificationManager notificationManager =
                    (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

            notificationManager.notify(0 , notificationBuilder.build());*/


            notification= new NotificationCompat.Builder(context);
            notification.setAutoCancel(true);

            notification.setSmallIcon(R.drawable.notify);
            notification.setTicker("Notification from Pass");
            notification.setWhen(System.currentTimeMillis());
            notification.setContentTitle("TNP");
            notification.setContentText(MainActivity.VALUE);

            Intent intents=new  Intent(context,MainActivity.class);
            PendingIntent pendingIntent=PendingIntent.getActivity(context,0,intents,PendingIntent.FLAG_NO_CREATE);
            notification.setContentIntent(pendingIntent);

            NotificationManager nm=(NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            nm.notify(UNIQUE_ID,notification.build());
        }
        else
        {
          String status= NetworkUtil.getConnectivityStatusString(context);

            if(status.equals("Mobile data enabled")|| status.equals("Wifi enabled"))
            {
                Intent startervice=new Intent(context,MyService.class);
                context.startService(startervice);

            }
            else
            {
                Intent startervice=new Intent(context,MyService.class);
                context.stopService(startervice);

            }
        }
    }
}
