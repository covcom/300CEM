package com.example.jianhuayang.mytests;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView textView = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        int daysLeft = intent.getIntExtra(MainActivity.DAYS_KEY, 0);
        textView.setText(Integer.toString(daysLeft + 18) + " days until 2017!");
    }
}
