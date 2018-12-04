package com.ingeapp.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.ingeapp.model.request.LoginRequest;
import com.ingeapp.service.LoginService;
import com.ingeapp.service.payload.UserResponse;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class LoginRepository {
    private LoginService loginService;
    private MutableLiveData<Boolean> isLogged = new MutableLiveData<>();

    public LoginRepository(LoginService loginService) {
        this.loginService = loginService;
    }

    public LiveData<Boolean> login(final LoginRequest loginRequest) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                loginService.login(loginRequest).enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        if (response.isSuccessful())
                            isLogged.postValue(true);
                        else
                            isLogged.postValue(false);
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        isLogged.postValue(false);
                    }
                });
            }
        });
        return isLogged;
    }
}
