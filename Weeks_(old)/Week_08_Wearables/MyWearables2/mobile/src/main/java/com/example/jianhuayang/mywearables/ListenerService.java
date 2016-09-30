package com.example.jianhuayang.mywearables;

import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;
/**
 * Created by jianhuayang on 14/11/2015.
 */
public class ListenerService extends WearableListenerService{

//    example from http://toastdroid.com/2014/08/18/messageapi-simple-conversations-with-android-wear/
//    and https://github.com/twotoasters/Wear-MessageApiDemo
    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        Log.d("DEBUG_KEY", "on received");
        showToast(messageEvent.getPath());
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
