package com.example.lcl;

import android.app.Application;

import com.example.lcl.util.SharedPref;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPref.initialize(this);
    }
}
