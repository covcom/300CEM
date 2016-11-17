package com.example.yang.mygraphics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    PageFragmentPagerAdapter pageFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        PageFragment pageFragment = new PageFragment();
//        fragmentTransaction.add(R.id.frameLayout, pageFragment);
//        fragmentTransaction.commit();
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        pageFragmentPagerAdapter = new PageFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageFragmentPagerAdapter);
    }

    private class PageFragmentPagerAdapter extends FragmentStatePagerAdapter {

        public PageFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.create(position);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
