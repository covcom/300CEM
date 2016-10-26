package com.example.jianhuayang.mylists;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by jianhuayang on 22/10/15.
 */
public class ImageAdapter extends BaseAdapter {

    private int[] candidatePhotos = PhotoListActivity.candidatePhotos;
    private Context context;

    public ImageAdapter(Context context) {
        this.context = context;
    }

    public int getCount() {
        return candidatePhotos.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(candidatePhotos[position]);
        return imageView;
    }
}
