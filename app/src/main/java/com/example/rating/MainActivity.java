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

public class MainActivity extends AppCompatActivity implements LeftRightFragment.leftRightFragmentListener,
    ImageRatingFragment.ImageRatingFragmentListener{
//    ImageView imgView;
//    static int index = 1;
    private LeftRightFragment leftRightFrag;
    private ImageRatingFragment imgRatingFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        leftRightFrag = new LeftRightFragment();
        imgRatingFrag = new ImageRatingFragment();

        // FragmentManager manager= getSupportFragmentManager();
        // FragmentTransaction transaction = manager.beginTransaction();
        // transaction.commit();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.LRFragFrame, leftRightFrag)
                .replace(R.id.ImgFragFrame, imgRatingFrag)
                .commit();
    }

    @Override
    public void onInputSent(String input) {
        ImageRatingFragment.updateImgView(input);
    }

    @Override
    public void onInputReceiver(CharSequence input) {
    }
}