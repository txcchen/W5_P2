package com.example.ratingbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LeftRightFragment extends Fragment {

    public LeftRightFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState ) {
        return inflater.inflate( R.layout.fragment_leftright,
                container, false );
    }
}
