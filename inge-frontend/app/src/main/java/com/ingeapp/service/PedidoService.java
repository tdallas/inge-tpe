package com.ingeapp.service;

import com.ingeapp.model.entities.Pedido;
import com.ingeapp.service.payload.PedidoRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PedidoService {

    @GET("/getAllPedidos")
    public Call<List<Pedido>> getAllPedidos();

    @POST("/pedido/crear")
    public Call<Pedido> crearPedido(@Body PedidoRequest pedidoRequest);

}
