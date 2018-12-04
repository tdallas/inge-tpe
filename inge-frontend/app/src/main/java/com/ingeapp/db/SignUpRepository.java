package com.ingeapp.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.ingeapp.model.request.SignUpRequest;
import com.ingeapp.service.SignUpService;
import com.ingeapp.service.payload.UserResponse;

import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpRepository{
    private SignUpService signUpService;
    private MutableLiveData<Boolean> isSigned = new MutableLiveData<>();

    public SignUpRepository(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    public LiveData<Boolean> signUp(final SignUpRequest signUpRequest) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                signUpService.signUp(signUpRequest).enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        isSigned.postValue(true);
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        isSigned.postValue(false);
                    }
                });
            }
        });
        return isSigned;
    }
}
