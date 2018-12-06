package com.ingeapp.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.ingeapp.model.entities.Pedido;
import com.ingeapp.service.PedidoService;
import com.ingeapp.service.payload.PedidoRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class PedidoRepository {
    private final PedidoService pedidoService;
    private MutableLiveData<List<Pedido>> pedidos;
    private MutableLiveData<Boolean> crearPedido;

    public PedidoRepository(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    public LiveData<List<Pedido>> getAllPedidos() {
        pedidos = new MutableLiveData<>();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                pedidoService.getAllPedidos().enqueue(new Callback<List<Pedido>>() {
                    @Override
                    public void onResponse(Call<List<Pedido>> call, Response<List<Pedido>> response) {
                        if (response.body() != null) {
                            pedidos.postValue(response.body());
                        } else {
                            pedidos.postValue(new ArrayList<Pedido>());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Pedido>> call, Throwable t) {

                    }
                });
            }
        });
        return pedidos;
    }

    public LiveData<Boolean> crearPedido(final PedidoRequest pedidoRequest) {
        crearPedido = new MutableLiveData<>();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                pedidoService.crearPedido(pedidoRequest).enqueue(new Callback<Pedido>() {
                    @Override
                    public void onResponse(Call<Pedido> call, Response<Pedido> response) {
                        crearPedido.postValue(true);
                    }

                    @Override
                    public void onFailure(Call<Pedido> call, Throwable t) {
                        crearPedido.postValue(false);
                    }
                });
            }
        });
        return crearPedido;
    }
}
