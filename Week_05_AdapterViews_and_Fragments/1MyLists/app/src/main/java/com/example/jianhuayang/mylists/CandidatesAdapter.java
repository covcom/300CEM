package com.example.jianhuayang.mylists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jianhuayang on 22/10/15.
 */
public class CandidatesAdapter extends ArrayAdapter<Candidates> {

    private int resource;
    private ArrayList<Candidates> candidates;
    private Context context;

    public CandidatesAdapter(Context context, int resource, ArrayList<Candidates> candidates) {
        super(context, resource, candidates);
        this.resource = resource;
        this.candidates = candidates;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        try{
            if (v == null){
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = layoutInflater.inflate(resource, parent, false);
            }

            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
            TextView textViewName = (TextView) v.findViewById(R.id.textViewName);
            TextView textViewDetail = (TextView) v.findViewById(R.id.textViewDetail);

            imageView.setImageResource(candidates.get(position).getPhoto());
            textViewName.setText(candidates.get(position).getName());
            textViewDetail.setText(candidates.get(position).getDetail());

        }
        catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return v;
    }

}
