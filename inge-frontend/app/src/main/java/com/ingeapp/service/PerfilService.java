package com.ingeapp.service;

import com.ingeapp.model.entities.Cliente;
import com.ingeapp.service.payload.ClienteResponse;
import com.ingeapp.service.payload.UpdateRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PerfilService {

    @POST("/update")
    public Call<Boolean> updateInfo(@Body UpdateRequest updateRequest);

    @GET("/getUsuarios")
    public Call<List<ClienteResponse>> getUsuarios();
}
