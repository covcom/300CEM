package com.example.jianhuayang.mytests;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        textView = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        int daysLeft = intent.getIntExtra(MainActivity.DAYS_KEY, 0);
        textView.setText(Integer.toString(daysLeft + 13) + " days until 2016!" );

    }
}
