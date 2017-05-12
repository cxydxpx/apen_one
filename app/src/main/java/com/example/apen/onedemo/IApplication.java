package com.example.apen.onedemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by 002 on 2017/3/14.
 */

public class IApplication extends Application {
    private static IApplication instance;
    public static final String apen = "apen";
    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
//        FreelineCore.init(this);
    }

    public static Context getInstance() {
        return instance;
    }

}
