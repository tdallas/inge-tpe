package com.ingeapp.service;

import com.ingeapp.service.payload.UpdateRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PerfilService {

    @POST("/update")
    public Call<Boolean> updateInfo(@Body UpdateRequest updateRequest);
}
