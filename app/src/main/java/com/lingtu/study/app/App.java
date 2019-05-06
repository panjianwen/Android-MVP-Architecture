package com.lingtu.study.app;

import android.app.Application;

/**
 * Created by pan on 2019/5/5.
 */
public class App extends Application {

    private static App mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static App getInstance() {
        return mContext;
    }
}
