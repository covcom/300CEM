package com.example.jianhuayang.mywearables;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static final String DEBUG_KEY = "DEBUG_KEY";
    public void onStartClick(View v) {
        startService(new Intent(this, CountingService.class));
        Log.d(DEBUG_KEY, "service started");
    }
}
