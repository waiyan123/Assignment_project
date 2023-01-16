package com.tunity.assignment.ui.util;


import android.os.Looper;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class NetworkStateManager {
    private static NetworkStateManager INSTANCE;
    private static final MutableLiveData<Boolean> activeNetworkStatusMLD = new MutableLiveData<>();
    private NetworkStateManager() {}

    public static synchronized NetworkStateManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NetworkStateManager();
        }
        return INSTANCE;
    }

    /**
     * Updates the active network status live-data
     */
    public void setNetworkConnectivityStatus(boolean connectivityStatus) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            activeNetworkStatusMLD.setValue(connectivityStatus);
        } else {
            activeNetworkStatusMLD.postValue(connectivityStatus);
        }
    }

    /**
     * Returns the current network status
     */
    public LiveData<Boolean> getNetworkConnectivityStatus() {
        return activeNetworkStatusMLD;
    }
}