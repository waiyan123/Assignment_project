package com.tunity.assignment.ui;

import android.app.Application;

import com.tunity.assignment.ui.util.NetworkStatusUtil;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class MyApplication extends Application {

    public NetworkStatusUtil mNetworkStatusUtil;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetworkStatusUtil = new NetworkStatusUtil(getApplicationContext());
        mNetworkStatusUtil.checkNetworkState();
        mNetworkStatusUtil.registerNetworkCallbackEvents();
    }
}
