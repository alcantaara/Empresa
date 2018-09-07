package com.marina.empresas;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.SearchView;

import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import android.widget.TextView;
import android.widget.Toast;

import com.marina.empresas.retrofit.BuscaEmpresas;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ListView lista;
    private TextView buscar_home;
    private SearchView searchView;
    private BuscaEmpresas buscaEmpresas;
    private MenuItem itemmenu;
    private ArrayList<Empresa> empresas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final ActionBar abar = getSupportActionBar();
        abar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradiente));
        View viewActionBar = getLayoutInflater().inflate(R.layout.actionbar, null);
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.CENTER);
        abar.setCustomView(viewActionBar, params);
        abar.setDisplayShowCustomEnabled(true);
        abar.setDisplayShowTitleEnabled(false);

        lista = findViewById(R.id.lista);
        buscar_home = findViewById(R.id.busca_home);

    }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.menu_actionbar, menu);

            UserRequest userRequest =  (UserRequest) getIntent().getSerializableExtra("user");
            buscaEmpresas = new BuscaEmpresas(userRequest,HomeActivity.this);
            itemmenu = menu.findItem(R.id.buscar);
            searchView = (SearchView) itemmenu.getActionView();


            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                @Override
                public boolean onQueryTextSubmit(String resultado) {
                    if (!searchView.isIconified()) {
                        buscaEmpresas.BuscarEmpresas(resultado,HomeActivity.this);
                    }
                    itemmenu.collapseActionView();
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String text) {
                    return false;
                }
            });


            return true;
        }

        public void msgerror(String erro) {
            Toast.makeText(getBaseContext(), erro, Toast.LENGTH_LONG).show();

        }
        public void Buscar(final EmpresaLista empresaList){



            empresas = empresaList.getLista();
            if(empresas.size()==0){
                Toast.makeText(this, "Nenhum resultado obtido!", Toast.LENGTH_SHORT).show();

            }
            else {

                buscar_home.setVisibility(View.INVISIBLE);

                final EmpresaAdapter empresaAdapter = new EmpresaAdapter(empresas, getBaseContext());
                lista.setAdapter(empresaAdapter);

                lista.setVisibility(View.VISIBLE);

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(HomeActivity.this, DadosEmpresas.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("nome",empresas.get(position).getEnterpriseName());
                        bundle.putString("descricao",empresas.get(position).getDescription());

                        i.putExtras(bundle);
                        startActivity(i);
                    }
                });

            }



        }


   }

