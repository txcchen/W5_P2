package com.example.rating;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;

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

//    @Override
//    public void buttonClick() {
//        imgView= (ImageView) ImageRatingFragment.getImgView();
//        imgView.setImageResource(R.drawable.cat_screech);
//    }
}