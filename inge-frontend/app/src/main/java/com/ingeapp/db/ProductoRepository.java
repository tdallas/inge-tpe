package com.ingeapp.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.ingeapp.model.entities.Producto;
import com.ingeapp.service.ProductoService;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class ProductoRepository {

    private final ProductoService productoService;
    private MutableLiveData<List<Producto>> productos;

    public ProductoRepository(ProductoService productoService) {
        this.productoService = productoService;
    }

    public LiveData<List<Producto>> getAllProductos() {
        productos = new MutableLiveData<>();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                productoService.getAllProductos().enqueue(new Callback<List<Producto>>() {
                    @Override
                    public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                        productos.postValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Producto>> call, Throwable t) {

                    }
                });
            }
        });
        return productos;
    }
}
