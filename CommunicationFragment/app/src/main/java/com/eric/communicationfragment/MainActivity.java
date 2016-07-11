package com.eric.communicationfragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    public void responder(String data) {
        android.app.FragmentManager gerenciador = getFragmentManager();
        FragmentB gerenciadorFragmentB = (FragmentB) gerenciador.findFragmentById(R.id.fragment2);
        gerenciadorFragmentB.changerText(data);
    }
}
