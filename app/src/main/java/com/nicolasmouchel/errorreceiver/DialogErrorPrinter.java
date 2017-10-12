package com.nicolasmouchel.errorreceiver;

import android.app.Activity;
import android.support.v7.app.AlertDialog;

import java.util.Locale;

public class DialogErrorPrinter implements ErrorPrinter<Activity> {

    @Override
    public void print(Activity context, int code, String message) {
        new AlertDialog.Builder(context)
            .setTitle(String.format(Locale.getDefault(), "Error %d", code))
            .setMessage(message)
            .create()
            .show();
    }
}
