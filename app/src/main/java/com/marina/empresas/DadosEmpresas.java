package com.marina.empresas;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toolbar;

public class DadosEmpresas extends AppCompatActivity {

    private TextView dados;
    private String detalhesEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_empresas);

        dados = (TextView) findViewById(R.id.textoEmpresa);
        detalhesEmpresa = getIntent().getStringExtra("descricao").toString();
        dados.setText(detalhesEmpresa);


        final ActionBar toolbar = getSupportActionBar();
        toolbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradiente));
        toolbar.setTitle(getIntent().getStringExtra("nome").toString());
        toolbar.setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu) {

        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
        finish();
        return true;

    }

}
