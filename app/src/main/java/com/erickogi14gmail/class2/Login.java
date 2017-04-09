package com.erickogi14gmail.class2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;
    TextView txtSignUp;
    private AppCompatButton buttonLogin;
    PrefrenceManager prefrnceManager = new PrefrenceManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        txtSignUp=(TextView)findViewById(R.id.linkSignup) ;

        buttonLogin = (AppCompatButton) findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String details[]=prefrnceManager.getDetails(getApplicationContext());
                if(editTextEmail.getText().toString().equals(details[6])&&editTextPassword.getText().toString().equals(details[7])){
                    startActivity(new Intent(Login.this,Profile.class));
                }
                else{
                    Toast.makeText(Login.this, "Enter correct details", Toast.LENGTH_LONG).show();
                }
            }
        });

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,MainActivity.class));
            }
        });
    }
}
