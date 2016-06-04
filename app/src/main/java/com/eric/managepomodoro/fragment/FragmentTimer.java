package com.eric.managepomodoro.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.eric.managepomodoro.R;
import com.eric.managepomodoro.count.ContadorRegressivo;
import com.eric.managepomodoro.count.OnOneOffClickListener;

import java.util.concurrent.TimeUnit;

/**
 * Created by Eric on 31/05/2016.
 */

public class FragmentTimer extends Fragment{

    private Button btnPlay, btnStop;
    TextView textViewTime;
    private static final String FORMAT = "%02d:%02d";
    private boolean playAtivo, stopAtivo;
    private static ContadorRegressivo contador = null;

    public FragmentTimer(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_timer, container, false);

        btnPlay = (Button)rootView.findViewById(R.id.btnPlay);
        btnStop = (Button)rootView.findViewById(R.id.btnStop);
        textViewTime = (TextView)rootView.findViewById(R.id.textViewTime);


        btnPlay.setOnClickListener(new OnOneOffClickListener() {
            @Override
            public void onOneClick(View v) {
                contador = new ContadorRegressivo(600000, 1000, textViewTime);
                contador.start();
                Toast.makeText(getActivity(), "CONTADOR DE ATIVIDADE INICIADA", Toast.LENGTH_SHORT).show();
                playAtivo = true;
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(playAtivo = true){
                    Toast.makeText(getActivity(), "CONTADOR ZERADO", Toast.LENGTH_SHORT).show();
                    contador.start();
                }else{
                    Toast.makeText(getActivity(), "NÃO PODE SER ZERADO, PQ NEM COMEÇO", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return rootView;
    }
}
