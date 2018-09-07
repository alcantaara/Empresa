package com.marina.empresas.services;

import com.marina.empresas.EmpresaLista;
import com.marina.empresas.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface EmpresaService {

    @POST("users/auth/sign_in")
    Call<User> login(@Body User user);

    @GET("enterprises")
    Call<EmpresaLista> empresaLista(
            @Header("access-token") String access_token,
            @Header("client") String client,
            @Header("uid") String uid,
            @Query("name") String name);

}
