package com.eric.managepomodoro.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eric.managepomodoro.R;

/**
 * Created by Eric on 01/06/2016.
 */
public class FragmentSobre extends Fragment {

    public FragmentSobre(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sobre, container, false);
        return rootView;
    }
}
