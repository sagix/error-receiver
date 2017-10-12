package com.nicolasmouchel.errorreceiver;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.nicolasmouchel.errorreceiver.ErrorObserver;

public class ErrorReceiver extends BroadcastReceiver {

    private final ErrorObserver errorObserver;

    public ErrorReceiver(ErrorObserver errorObserver) {
        this.errorObserver = errorObserver;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("Receiver", "receiving message");
        final Bundle extras = intent.getExtras();
        if (extras.containsKey("code") && extras.containsKey("message")) {
            errorObserver.sendMessage(extras.getInt("code"), extras.getString("message"));
        }
    }
}
