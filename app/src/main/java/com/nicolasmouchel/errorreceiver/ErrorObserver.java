package com.nicolasmouchel.errorreceiver;
import android.app.Activity;
import android.app.Application;

public class ErrorObserver {

    private final ErrorPrinter<Application> applicationErrorPrinter;
    private final ErrorPrinter<Activity> activityErrorPrinter;

    private final Application application;
    private Activity activity;

    public ErrorObserver(
        Application application,
        ErrorPrinter<Application> applicationErrorPrinter,
        ErrorPrinter<Activity> activityErrorPrinter
    ) {
        this.application = application;
        this.applicationErrorPrinter = applicationErrorPrinter;
        this.activityErrorPrinter = activityErrorPrinter;
    }

    public void sendMessage(int code, String message) {
        if (activity != null) {
            activityErrorPrinter.print(activity, code, message);
        } else {
            applicationErrorPrinter.print(application, code, message);
        }
    }

    public void register(Activity activity) {
        this.activity = activity;
    }

    public void unregister() {
        this.activity = null;
    }
}
