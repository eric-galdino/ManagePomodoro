package com.eric.communicationfragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Eric on 28/06/2016.
 */
public class FragmentUm extends Fragment {

    EnviarMensagem SM;
    Button bn;
    EditText msg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v;
        v = inflater.inflate(R.layout.fragment_um, container, false);
        msg = (EditText)v.findViewById(R.id.mensagem);
        bn = (Button)v.findViewById(R.id.btn_enviar);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mensagem;
                mensagem = msg.getText().toString();
                SM.enviarMensagem(mensagem);
            }
        });
        return v;
    }

    interface EnviarMensagem
    {
        public void  enviarMensagem(String message);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            SM = (EnviarMensagem)activity;
        }catch (ClassCastException e){
            throw new ClassCastException("Deve implementar corretamente");
        }

    }
}
