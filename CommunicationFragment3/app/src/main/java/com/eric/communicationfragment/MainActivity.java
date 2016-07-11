package com.eric.communicationfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentUm.EnviarMensagem{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void enviarMensagem(String mensagem) {

        FragmentDois f2 = (FragmentDois) getFragmentManager().findFragmentById(R.id.f2);
        f2.getMensagem(mensagem);


    }

}
