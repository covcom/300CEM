package com.example.jianhuayang.myfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.jianhuayang.myfragments.data.Candidates;

public class ListFragmentActivity extends AppCompatActivity implements ItemFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fragment);

        getFragmentManager().beginTransaction().add(R.id.ListFrameLayout, new ItemFragment()).commit();
    }

    @Override
    public void onFragmentInteraction(int position){
        Toast.makeText(getBaseContext(), Candidates.candidateNames[position], Toast.LENGTH_SHORT).show();
    }
}
