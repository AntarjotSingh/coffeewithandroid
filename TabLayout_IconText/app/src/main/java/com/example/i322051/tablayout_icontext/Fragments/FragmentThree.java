package com.example.i322051.tablayout_icontext.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.i322051.tablayout_icontext.R;

/**
 * Created by I322051 on 7/11/2016.
 */
public class FragmentThree extends Fragment {

    //Constructor
    public FragmentThree() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Returns the respective layout file for Fragment
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

}
