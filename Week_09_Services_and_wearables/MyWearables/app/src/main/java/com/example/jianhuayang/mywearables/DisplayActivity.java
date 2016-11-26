package com.example.jianhuayang.mywearables;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        if (getIntent() != null) {
            Intent intent = getIntent();
            TextView textView = (TextView) findViewById(R.id.display);
            textView.setText("Time elapsed (seconds):\n" + intent.getStringExtra(CountingService.REPORT_KEY));
        }
    }
}
