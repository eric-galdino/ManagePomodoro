package com.eric.managepomodoro.firebase;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Eric on 05/07/2016.
 */
public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
