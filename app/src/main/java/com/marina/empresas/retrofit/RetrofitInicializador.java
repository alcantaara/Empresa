package com.marina.empresas.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInicializador {

    private static final String Url = "http://empresas.ioasys.com.br";
    private static final String Versao = "v1";

    public Retrofit getInicializador(){
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(Url + "/api/" + Versao + "/" )
                .addConverterFactory(GsonConverterFactory.create())
                .build();

            return retrofit;
    }
}
