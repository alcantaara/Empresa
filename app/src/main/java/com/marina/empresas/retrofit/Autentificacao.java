package com.marina.empresas.retrofit;

import android.util.Log;
import android.widget.Toast;

import com.marina.empresas.LoginActivity;
import com.marina.empresas.R;
import com.marina.empresas.User;
import com.marina.empresas.UserRequest;
import com.marina.empresas.services.EmpresaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Autentificacao {

    private User user;
    private Retrofit retrofit;
    private final EmpresaService empresaService;
    final LoginActivity loginActivity;


    public Autentificacao(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;

        RetrofitInicializador conection = new RetrofitInicializador();
        retrofit = conection.getInicializador();
        empresaService = retrofit.create(EmpresaService.class);
    }

    public void Logar(String email, String senha) {

        user = new User(email, senha);

        Call call = empresaService.login(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful()) {

                    UserRequest useRequest = new UserRequest(response.headers().get("access-token"),
                            response.headers().get("client"),
                            response.headers().get("uid"));

                    Log.d("access-token", response.headers().get("access-token"));
                    Log.d("client", response.headers().get("client"));
                    Log.d("uid", response.headers().get("uid"));
                    loginActivity.Chamada(useRequest);

                } else {

                    loginActivity.msgerror(loginActivity.getString(R.string.erro));
                }

            }

            @Override
            public void onFailure(Call call, Throwable t) {


                loginActivity.msgerror(t.getMessage());


            }
        });
    }
}
