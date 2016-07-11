package com.eric.communicationfragment;

import android.app.Fragment;
import android.hardware.display.VirtualDisplay;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Eric on 28/06/2016.
 */
public class FragmentDois extends Fragment {

    EditText txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v;
        v = inflater.inflate(R.layout.fragment_dois, container, false);
        txt = (EditText) v.findViewById(R.id.editText);
        return v;
    }

    public void getMensagem(String mensagem){
        txt.setText(mensagem);
    }
}
