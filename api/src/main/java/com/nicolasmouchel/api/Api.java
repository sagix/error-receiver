package com.nicolasmouchel.api;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class Api {

    private final Context context;

    public Api(Context context) {

        this.context = context;
    }

    public static Api with(Context context) {
        return new Api(context);
    }

    public void load() {
        new Thread((new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Log.e(TAG, "", e);
                }
                final Intent intent = new Intent();
                intent.setAction("NOTIFY_ERROR");
                intent.putExtra("code", 403);
                intent.putExtra("message", "Message sent through a receiver");
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                Log.v("Activity", "sending message");
            }
        })).start();
    }
}
