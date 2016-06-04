package com.eric.managepomodoro.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eric.managepomodoro.R;

/**
 * Created by Eric on 31/05/2016.
 */
public class FragmentAtividades extends Fragment {

    public FragmentAtividades(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_atividades, container, false);
        return rootView;
    }
}
