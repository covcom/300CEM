package com.example.jianhuayang.myfragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v){

        switch (v.getId()){
            case R.id.dynamicFragments:
                startActivity(new Intent(this, DynamicActivity.class));
                break;
            case R.id.listFragment:
                startActivity(new Intent(this, ListFragmentActivity.class));
                break;
            case R.id.multipanel:
                startActivity(new Intent(this, MultiPanelActivity.class));
                break;
        }

    }
}
