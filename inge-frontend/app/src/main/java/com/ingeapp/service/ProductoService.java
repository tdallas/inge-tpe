package com.ingeapp.service;

import com.ingeapp.model.entities.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductoService {

    @GET("/getAllProductos")
    public Call<List<Producto>> getAllProductos();
}
