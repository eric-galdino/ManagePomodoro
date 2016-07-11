package com.eric.managepomodoro.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.eric.managepomodoro.R;
import com.eric.managepomodoro.communication.Communicator;
import com.eric.managepomodoro.count.ContadorRegressivo;
import com.eric.managepomodoro.count.OnOneOffClickListener;

import java.io.Serializable;

/**
 * Created by Eric on 31/05/2016.
 */

public class FragmentTimer extends Fragment{

    private Button btnPlay, btnZerar;
    TextView textViewTime;
    private static final String FORMAT = "%02d:%02d";
    private boolean playAtivo;
    private static ContadorRegressivo contador;

    //Communicator communicator;

    public FragmentTimer(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_timer, container, false);

        if((savedInstanceState != null) && (savedInstanceState.getSerializable("contador") != null))
            contador = (ContadorRegressivo) savedInstanceState.getSerializable("contador");

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        btnPlay = (Button) getActivity().findViewById(R.id.btnPlay);
        btnZerar = (Button) getActivity().findViewById(R.id.btnZerar);
        textViewTime = (TextView) getActivity().findViewById(R.id.textViewTime);
        //communicator = (Communicator) getActivity();

        btnPlay.setOnClickListener(new OnOneOffClickListener() {
            @Override
            public void onOneClick(View v) {
                contador = new ContadorRegressivo(1500000, 1000, textViewTime);
                Toast.makeText(getActivity(), "TIMER DA ATIVIDADE INICIADO", Toast.LENGTH_SHORT).show();
                contador.start();
                playAtivo = true;
            }
        });

        btnZerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playAtivo = true){
                    Toast.makeText(getActivity(), "TIMER ZERADO", Toast.LENGTH_SHORT).show();
                    contador.start();

                }else{
                    Toast.makeText(getActivity(), "NÃO PODE SER ZERADO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("contador", (Serializable) contador);
    }

    /**
     * Called when the Fragment is no longer resumed.  This is generally
     * tied to {@link Activity#onPause() Activity.onPause} of the containing
     * Activity's lifecycle.
     *
    @Override
    public void onPause() {

    }*/
}
