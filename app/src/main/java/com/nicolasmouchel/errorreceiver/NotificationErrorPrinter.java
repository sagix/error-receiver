package com.nicolasmouchel.errorreceiver;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.support.v7.app.NotificationCompat;

import java.util.Locale;

import static android.content.Context.NOTIFICATION_SERVICE;

public class NotificationErrorPrinter implements ErrorPrinter<Application> {

    @Override
    public void print(Application context, int code, String message) {
        final NotificationManager notificationManager =
            (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        final Notification notification = new NotificationCompat.Builder(context)
            .setContentTitle(String.format(Locale.getDefault(), "Error %d", code))
            .setContentText(message)
            .setSmallIcon(R.mipmap.ic_launcher)
            .build();
        notificationManager.notify(1, notification);
    }
}
