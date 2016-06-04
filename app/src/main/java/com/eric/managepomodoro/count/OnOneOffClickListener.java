package com.eric.managepomodoro.count;

import android.view.View;

/**
 * Created by Eric on 03/06/2016.
 */
public abstract class OnOneOffClickListener implements View.OnClickListener {

    private boolean clicado = true;

    @Override
    public final void onClick(View v) {
        if (clicado) {
            clicado = false;
            onOneClick(v);
        }
    }

    public abstract void onOneClick(View v);

    //Permite outro click só quando resetar
    public void reset() {
        clicado = true;
    }
}
