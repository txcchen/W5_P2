package com.example.ratingbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class ImageRatingFragment extends Fragment {

    public ImageRatingFragment( ) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState ) {
        return inflater.inflate( R.layout.fragment_imgrating,
                container, false );
    }
}
