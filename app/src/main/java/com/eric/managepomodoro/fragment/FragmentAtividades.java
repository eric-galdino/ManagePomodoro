package com.eric.managepomodoro.fragment;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.eric.managepomodoro.R;
import com.eric.managepomodoro.adapter.CustomAdapter;

/**
 * Created by Eric on 31/05/2016.
 */
public class FragmentAtividades extends Fragment {

    ListView lv;

    public FragmentAtividades() {

    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_atividades, container, false);

        lv = (ListView) lv.findViewById(R.id.listView1);

        CustomAdapter adapter = new CustomAdapter(FragmentAtividades.this.getContext());
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int pos,
                                    long id) {

                /*Intent i = new Intent(this,FragmentDetalheAtividade.class);
                i.putExtra("Position", pos);
                startActivity(i);*/

            }
        });

        return rootView;
    }




}
