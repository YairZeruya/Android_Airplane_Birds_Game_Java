package com.example.hw1;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SignalGenerator.init(this);
    }
}

    

