package com.example.jianhuayang.myfragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jianhuayang.myfragments.data.Candidates;

public class MultiPanelActivity extends AppCompatActivity implements ItemFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_panel);

        if (savedInstanceState == null){
            getFragmentManager().beginTransaction().add(R.id.fragmentLeft, new ItemFragment()).commit();
            getFragmentManager().beginTransaction().add(R.id.fragmentRight, new DetailsFragment()).commit();
        }
    }

    @Override
    public void onFragmentInteraction(int position) {

        DetailsFragment detailsFragment = (DetailsFragment)
                getFragmentManager().findFragmentById(R.id.fragmentRight);

        if (detailsFragment != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
//            ((TextView) findViewById(R.id.description)).setText(Candidates.candidateDetails[position]);

            DetailsFragment detailsFragmentNew = new DetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(DetailsFragment.POSITION, position);
            detailsFragmentNew.setArguments(bundle);
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentRight, detailsFragmentNew);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }

    }

}
