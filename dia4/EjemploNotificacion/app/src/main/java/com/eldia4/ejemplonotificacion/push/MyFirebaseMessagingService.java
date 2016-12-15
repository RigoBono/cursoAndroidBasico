package com.eldia4.ejemplonotificacion.push;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.eldia4.ejemplonotificacion.MainActivity;
import com.eldia4.ejemplonotificacion.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by rigobono on 15/12/16.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.i("test notificatin",remoteMessage.toString());
        Log.i("REMOTEEXAMPLE",remoteMessage.getData().toString());
        String mensajeRecibido=remoteMessage.getData().toString();
        sendNotification(mensajeRecibido);
    }

    private void sendNotification(String messageBody) {
        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Test IT")
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri);

        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);
        notificationBuilder.setContentIntent(pIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);



        notificationManager.notify(0, notificationBuilder.build());


    }



}
