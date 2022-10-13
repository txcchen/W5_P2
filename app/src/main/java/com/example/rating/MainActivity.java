package com.example.rating;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements LeftRightFragment.LRButtons{

    ImageView imgView;
    static int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager= getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        ImageRatingFragment imgf = new ImageRatingFragment();
        transaction.add(R.id.ImgFragFrame, imgf);
        transaction.commit();


    }

    @Override
    public void buttonClick(View view) {
        Button btn = (Button) view;
        String btnText = btn.getText().toString();

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
}