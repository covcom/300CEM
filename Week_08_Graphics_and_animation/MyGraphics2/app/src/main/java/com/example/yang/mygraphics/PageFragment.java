package com.example.yang.mygraphics;


import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    //    public static final String DEBUG_KEY = "DEBUG_KEY";
    private CustomDrawableView customDrawableView;
    private TextView textView;
    private Button button;
    private ImageView imageView;
    private int pageNumber;
    private AnimatorSet set;
    private boolean isAnimatorSetOn = false;
    private Animation hyperspaceJumpAnimation;

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
        textView = (TextView) v.findViewById(R.id.title);
        textView.setText("This is page No. " + Integer.toString(pageNumber + 1));
        button = (Button) v.findViewById(R.id.button);
        imageView = (ImageView) v.findViewById(R.id.body);

        if (pageNumber == 0) {
            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.gradient_box);
            imageView.setImageDrawable(drawable);
            set = (AnimatorSet) AnimatorInflater.loadAnimator(getContext(), R.animator.property_animator);
            set.setTarget(imageView);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (!isAnimatorSetOn) {
                        set.start();
                        isAnimatorSetOn = true;
                    } else {
                        set.cancel();
                        isAnimatorSetOn = false;
                    }

                    Log.d("DEBUG_KEY", "clicked button page 1");
                }
            });
        } else if (pageNumber == 1) {
            imageView.setVisibility(View.GONE);
            RelativeLayout relativeLayout = (RelativeLayout) v.findViewById(R.id.container);
            customDrawableView = new CustomDrawableView(getContext());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(80, 80, 0, 0);
            params.addRule(RelativeLayout.BELOW, textView.getId());
            relativeLayout.addView(customDrawableView, params);

            hyperspaceJumpAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.hyperspace_jump);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (!isAnimatorSetOn) {
                        customDrawableView.startAnimation(hyperspaceJumpAnimation);
                        isAnimatorSetOn = true;
                    } else {
                        customDrawableView.clearAnimation();
                        isAnimatorSetOn = false;
                    }

                    Log.d("DEBUG_KEY", "clicked button page 1");
                }
            });
        }
        return v;
    }
}
