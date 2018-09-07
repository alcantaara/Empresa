package com.marina.empresas.retrofit;


import android.util.Log;

import com.marina.empresas.EmpresaLista;
import com.marina.empresas.HomeActivity;
import com.marina.empresas.UserRequest;
import com.marina.empresas.services.EmpresaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BuscaEmpresas {
    private Retrofit retrofit;
    private EmpresaService empresaService;
    private UserRequest userRequest;
    private HomeActivity homeActivity;



    public BuscaEmpresas(UserRequest userRequest,HomeActivity homeActivity){
        RetrofitInicializador conection = new RetrofitInicializador();
        retrofit = conection.getInicializador();
        this.empresaService = retrofit.create(EmpresaService.class);
        this.userRequest = userRequest;
        this.homeActivity = homeActivity;
    }


    public void BuscarEmpresas(String texto, final HomeActivity homeActivity){


        if(userRequest != null){
            Call call =  empresaService.empresaLista(userRequest.getAccessToken(),userRequest.getClient(), userRequest.getUid(), texto);

            call.enqueue(new Callback<EmpresaLista>() {
                @Override
                public void onResponse(Call<EmpresaLista> call, Response<EmpresaLista> response) {

                    Log.d("Body ", response.body().toString());
                    homeActivity.Buscar(response.body());
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    homeActivity.msgerror(t.getMessage());
                }
            });
        }
    }
}
