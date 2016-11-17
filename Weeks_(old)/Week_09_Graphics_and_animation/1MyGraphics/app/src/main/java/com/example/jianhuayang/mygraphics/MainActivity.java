package com.example.jianhuayang.mygraphics;

//import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    PageFragmentPagerAdapter pageFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        PageFragment pageFragment = new PageFragment();
//        fragmentTransaction.add(R.id.frameLayout, pageFragment);
//        fragmentTransaction.commit();

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        pageFragmentPagerAdapter = new PageFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageFragmentPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class PageFragmentPagerAdapter extends FragmentStatePagerAdapter {

        public PageFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
//            Fragment fragment = new PageFragment();
//            Bundle bundle = new Bundle();
//            bundle.putInt(PageFragment.ARG_PAGE, position);
//            fragment.setArguments(bundle);
//            return fragment;
            return PageFragment.create(position);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}









