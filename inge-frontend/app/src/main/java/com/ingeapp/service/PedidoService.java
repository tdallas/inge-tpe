package com.ingeapp.service;

import com.ingeapp.model.entities.Pedido;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PedidoService {

    @GET("/getAllPedidos")
    public Call<List<Pedido>> getAllPedidos();

}
