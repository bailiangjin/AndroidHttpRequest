package com.bailiangjin.httprequest;

import android.app.Application;
import android.content.Context;

/**
 * Created by bailiangjin on 2017/2/16.
 */

public class MyApplication extends Application {

    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext =this.getApplicationContext();
    }

    public static Context getAppContext() {
        return appContext;
    }
}
