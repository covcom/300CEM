package com.example.jianhuayang.myfragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

public class MultiPanelActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_panel);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentLeft, new ItemFragment()).commit();
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentRight, new DetailsFragment()).commit();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DetailsFragment detailsFragmentNew = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(DetailsFragment.POSITION, position);
        detailsFragmentNew.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentRight, detailsFragmentNew);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        // If article frag is available, we're in two-pane layout...
        // Call a method in the ArticleFragment to update its content
        // ((TextView) findViewById(R.id.description)).setText(Candidates.candidateDetails[position]);
    }
}
