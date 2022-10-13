package com.example.rating;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LeftRightFragment extends Fragment {

    private leftRightFragmentListener listener;
    Button left;
    Button right;

    public interface leftRightFragmentListener{
        void onInputSent(String input);
    }

    public LeftRightFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_left_right, container, false);
        left = (Button) view.findViewById(R.id.left);
        right =(Button) view.findViewById(R.id.right);
        left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Button btn = (Button) v;
                String btnText = btn.getText().toString();
                Log.d("btnText", btnText);
                listener.onInputSent(btnText);
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Button btn = (Button) v;
                String btnText = btn.getText().toString();
                Log.d("btnText", btnText);
                listener.onInputSent(btnText);
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        if(context instanceof leftRightFragmentListener){
            listener = (leftRightFragmentListener) context;
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