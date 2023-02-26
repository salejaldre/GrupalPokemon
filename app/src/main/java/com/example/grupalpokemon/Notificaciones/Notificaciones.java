package com.example.grupalpokemon.Notificaciones;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.grupalpokemon.R;

public class Notificaciones {

    public static void creacrionDelCanalNotis(Context context) {

        NotificationChannel channel = new NotificationChannel("ID_NOTIFICATION", "Channel_01", NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("Descripcion");
        NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

    public static void notificar(Context context, String titulonoti, String contenidonoti){
        Notification notification = new NotificationCompat.Builder(context, "ID_NOTIFICATION")
                .setSmallIcon(R.drawable.noticolor)
                .setContentTitle(titulonoti)
                .setContentText(contenidonoti)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(1, notification);
    }
}
