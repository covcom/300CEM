package com.example.jianhuayang.myfragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            BlankFragment frag1 = new BlankFragment();
            fragmentTransaction.replace(R.id.dynamicContainer, frag1);
        } else {
            BlankFragment2 frag2 = new BlankFragment2();
            fragmentTransaction.replace(R.id.dynamicContainer, frag2);
        }
        fragmentTransaction.commit();
    }
}
