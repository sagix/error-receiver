package com.nicolasmouchel.errorreceiver;

import android.app.Application;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

public class MainApplication extends Application {

    private final IntentFilter filter = new IntentFilter("NOTIFY_ERROR");
    private ErrorActivityLifecycleCallbacks callback;
    private LocalBroadcastManager broadcastManager;
    private ErrorReceiver receiver;

    @Override
    public void onCreate() {
        super.onCreate();
        final ErrorObserver errorObserver = new ErrorObserver(
            this,
            new NotificationErrorPrinter(),
            new DialogErrorPrinter());
        callback = new ErrorActivityLifecycleCallbacks(errorObserver);
        receiver = new ErrorReceiver(errorObserver);
        broadcastManager = LocalBroadcastManager.getInstance(this);
        broadcastManager.registerReceiver(receiver, filter);
        registerActivityLifecycleCallbacks(callback);
    }

    @Override
    public void onTerminate() {
        broadcastManager.unregisterReceiver(receiver);
        unregisterActivityLifecycleCallbacks(callback);
        super.onTerminate();
    }
}
