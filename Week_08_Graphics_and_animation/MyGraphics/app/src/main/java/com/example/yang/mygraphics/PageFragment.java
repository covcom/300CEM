package com.example.yang.mygraphics;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    //    public static final String DEBUG_KEY = "DEBUG_KEY";
    private int pageNumber;

    public PageFragment() {
        // Required empty public constructor
    }

    public static PageFragment create(int pageNumber) {
        PageFragment pageFragment = new PageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_PAGE, pageNumber);
        pageFragment.setArguments(bundle);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        pageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_page, container, false);
//        Log.d(DEBUG_KEY, Integer.toString(pageNumber));
        TextView textView = (TextView) v.findViewById(R.id.title);
        textView.setText("This is page No. " + Integer.toString(pageNumber + 1));
        if (pageNumber == 0) {
            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.gradient_box);
            ImageView imageView = (ImageView) v.findViewById(R.id.body);
            imageView.setImageDrawable(drawable);
        } else if (pageNumber == 1) {
            ImageView imageView = (ImageView) v.findViewById(R.id.body);
            imageView.setVisibility(View.GONE);
            RelativeLayout relativeLayout = (RelativeLayout) v.findViewById(R.id.container);
            CustomDrawableView customDrawableView = new CustomDrawableView(getContext());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(80, 80, 0, 0);
            params.addRule(RelativeLayout.BELOW, textView.getId());
            relativeLayout.addView(customDrawableView, params);
        }
        return v;
    }
}
