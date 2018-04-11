package com.example.jakku.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by jakku on 4/11/2018.
 */

public class Myservice extends Service {
    private static final String TAG = "HelloService";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "Service onBind");

        return null;
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "Service onCreate");

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service onStartCommand");

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<=10; i++ ){
                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){

                    }
                }
                stopSelf();
            }
        }).start();

        return Service.START_STICKY;
    }



    @Override
    public void onDestroy() {
        Log.i(TAG, "Service onDestroy");

        super.onDestroy();
    }
}
