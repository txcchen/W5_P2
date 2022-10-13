package com.example.rating;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.util.ArrayList;

public class ImageRatingFragment extends Fragment{

    private ImageRatingFragmentListener listener;
    static Integer index = 1;
    View view;
    static ImageView imgView;
    protected static Integer[] imgNames = {R.drawable.cat, R.drawable.cat_screech, R.drawable.cat_flower};
    protected static Integer[] ratingNums = {3, 5, 4};
    static RatingBar ratingB;


    public ImageRatingFragment() {
        // Required empty public constructor
    }

    public interface ImageRatingFragmentListener{
        void onInputReceiver(CharSequence input);
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
//                i = MainActivity.index;
                ratingB.setRating(v);
                ratingNums[index] = (int) v;
//                Log.d("ratingNUM CHANGED", String.valueOf(ratingNums[i]));
            }

        });

        return view;
    }


    public static void updateImgView(String btnText){

        Log.d("btnText in IMAGE", btnText);
        Log.d("index", String.valueOf(index));
        if(btnText.equalsIgnoreCase("LEFT") && index > 0){
            index--;
        }
        if(btnText.equalsIgnoreCase("RIGHT") &&  index < ImageRatingFragment.imgNames.length-1 ){
            index++;
        }
        //else do nothing to the index--stay on same view
        Integer imgName = ImageRatingFragment.imgNames[index];
        Integer rating = ImageRatingFragment.ratingNums[index];
        ImageRatingFragment.imgView.setImageResource(imgName);
        ImageRatingFragment.ratingB.setRating(rating);

    }
    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        if(context instanceof ImageRatingFragmentListener){
            listener = (ImageRatingFragmentListener) context;
        }
        else{
        }
    }

    @Override
    public void onDetach(){
        super.onDetach();
        listener = null;
    }
}