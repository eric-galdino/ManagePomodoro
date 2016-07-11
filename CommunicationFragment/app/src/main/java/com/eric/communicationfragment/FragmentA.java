package com.eric.communicationfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Eric on 08/06/2016.
 */
public class FragmentA extends Fragment implements View.OnClickListener {

    Button button;
    int counter = 0;
    Communicator communicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_a, container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        communicator = (Communicator) getActivity();
        button =  (Button) getActivity().findViewById(R.id.button);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        counter++;
        if(counter == 1) communicator.responder("O botão foi clicado "+ counter +" vez!");
        else{communicator.responder("O botão foi clicado "+ counter +" vezes!");}
    }
}
