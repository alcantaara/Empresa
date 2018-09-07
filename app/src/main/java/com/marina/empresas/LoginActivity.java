package com.marina.empresas;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.marina.empresas.retrofit.Autentificacao;

public class LoginActivity extends AppCompatActivity {

    private Button bt_login;
    private EditText user;
    private EditText senha;
    private Autentificacao autentification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        final ActionBar abar = getSupportActionBar();
        abar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradiente));
        getSupportActionBar().hide();

        user = (EditText)findViewById(R.id.email);
        senha = (EditText)findViewById(R.id.senha);
        bt_login = (Button) findViewById(R.id.button_login);


        bt_login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                autentification = new Autentificacao(LoginActivity.this);
                autentification.Logar(user.getText().toString(),senha.getText().toString());
            }
        });

    }

    public void msgerror(String erro) {
        Toast.makeText(getBaseContext(), erro, Toast.LENGTH_LONG).show();

    }



    public void Chamada(UserRequest useRequest) {

        Intent i = new Intent(LoginActivity.this,HomeActivity.class);
        i.putExtra("user", useRequest);
        Toast.makeText(this, "Bem-Vindo!", Toast.LENGTH_SHORT).show();

        startActivity(i);

    }
}
