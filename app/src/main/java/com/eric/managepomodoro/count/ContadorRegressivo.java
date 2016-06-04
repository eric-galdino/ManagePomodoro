package com.eric.managepomodoro.count;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by Eric on 03/06/2016.
 */
public class ContadorRegressivo extends CountDownTimer{

    private TextView texView;
    private static final String FORMATACAO = "%02d:%02d";

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */

    public ContadorRegressivo(long millisInFuture, long countDownInterval, TextView textView) {
        super(millisInFuture, countDownInterval);
        this.texView = textView;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        this.texView.setText(""+String.format(FORMATACAO,TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) -
                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
    }

    @Override
    public void onFinish() {
        this.texView.setText("ACABOU");
    }
}
