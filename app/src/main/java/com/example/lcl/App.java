package com.example.lcl;

import android.app.Application;
import android.content.Context;

import com.example.lcl.util.SharedPref;

public class App extends Application {

    private static Context appContext;
    private static App appInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        SharedPref.initialize(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static Context getAppContext(){
        return appContext;
    }

    public static App getInstance(){
        return appInstance;
    }

}
