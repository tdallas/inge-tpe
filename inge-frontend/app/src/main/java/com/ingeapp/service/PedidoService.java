package com.ingeapp.service;

import com.ingeapp.model.entities.Pedido;
import com.ingeapp.service.payload.CalificarRequest;
import com.ingeapp.service.payload.PedidoRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PedidoService {

    @GET("/getAllPedidos")
    public Call<List<Pedido>> getAllPedidos();

    @POST("/pedido/crear")
    public Call<Pedido> crearPedido(@Body PedidoRequest pedidoRequest);

    @GET("/getAllPedidos/{idUser}")
    public Call<List<Pedido>> getAllPedidosByUserId(@Path("idUser") Long idUser);

    @GET("/getPedido/{id}")
    public Call<Pedido> getPedido(@Path("id") Long id);

    @POST("/calificar")
    public Call<Boolean> calificar(@Body CalificarRequest calificarRequest);

    @POST("/pedido/estado")
    public Call<Boolean> cambiarEstado(@Body long idPedido);
}
