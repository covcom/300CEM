package com.example.jianhuayang.myfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fragment);

        getSupportFragmentManager().beginTransaction().add(R.id.activity_list_fragment, new ItemFragment()).commit();
    }
}
