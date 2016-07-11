package com.eric.managepomodoro.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.eric.managepomodoro.R;
import com.eric.managepomodoro.adapter.CustomAdapter;

import java.util.List;

/**
 * Created by Eric on 31/05/2016.
 */
public class FragmentEstatisticas extends Fragment {

    public FragmentEstatisticas(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_estastisticas, container, false);
        return rootView;
    }


}
