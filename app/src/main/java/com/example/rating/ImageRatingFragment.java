package com.example.rating;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageRatingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageRatingFragment extends Fragment{

    Integer i = 0;
    View view;
    static ImageView imgView;
    protected static Integer[] imgNames = {R.drawable.cat, R.drawable.cat_screech, R.drawable.cat_flower};
    protected static Integer[] ratingNums = {3, 5, 4};
    static RatingBar ratingB;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ImageRatingFragment() {
        // Required empty public constructor
    }




    //getter
    public static View getImgView(){
        return imgView;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ImageRatingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ImageRatingFragment newInstance(String param1, String param2) {
        ImageRatingFragment fragment = new ImageRatingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_image_rating, container, false);
        imgView = view.findViewById(R.id.imageView);
        ratingB = view.findViewById(R.id.ratingBar);

        ratingB.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                i = MainActivity.index;
                ratingB.setRating(v);
                ratingNums[i] = (int) v;
//                Log.d("ratingNUM CHANGED", String.valueOf(ratingNums[i]));
            }

        });


        return view;
    }
}