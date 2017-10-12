package com.nicolasmouchel.errorreceiver;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

class ErrorActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    private ErrorObserver errorObserver;

    public ErrorActivityLifecycleCallbacks(ErrorObserver errorObserver) {
        this.errorObserver = errorObserver;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityStarted(Activity activity) {
        errorObserver.register(activity);

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        errorObserver.unregister();
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
