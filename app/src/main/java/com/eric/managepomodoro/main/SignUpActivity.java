package com.eric.managepomodoro.main;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.eric.managepomodoro.R;

/**
 * Created by Eric on 06/07/2016.
 */
public class SignUpActivity extends Activity {

    private static final String TAG = "SignUpActivity";

    private EditText nomeText;
    private EditText emailText;
    private EditText senhaText;
    private Button signupButton;
    private TextView loginLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nomeText = (EditText)findViewById(R.id.input_nome);
        emailText = (EditText)findViewById(R.id.input_email);
        senhaText = (EditText)findViewById(R.id.input_senha);
        signupButton = (Button)findViewById(R.id.btn_signup);
        loginLink = (TextView)findViewById(R.id.link_signup);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Criando conta...");
        progressDialog.show();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        onSignupSuccess();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    public void onSignupSuccess() {
        signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "\n" + "Falha na autenticação", Toast.LENGTH_LONG).show();
        signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        if (nomeText.getText().equals(emailText) || nomeText.getText().length() < 3) {
            nomeText.setError("Pelo menos 3 caracteres");
            valid = false;
        } else {
            nomeText.setError(null);
        }

        if (emailText.getText().equals(emailText) || !android.util.Patterns.EMAIL_ADDRESS.matcher(emailText.getText()).matches()) {
            emailText.setError("Digite um endereço de e-mail válido");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (senhaText.getText().equals(senhaText) || senhaText.length() < 4 || senhaText.length() > 10) {
            senhaText.setError("Entre 4 e 10 caracteres!");
            valid = false;
        } else {
            senhaText.setError(null);
        }

        return valid;
    }
}
