package com.ingeapp.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.ingeapp.model.entities.Pedido;
import com.ingeapp.service.PedidoService;
import com.ingeapp.service.payload.CalificarRequest;
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
    private MutableLiveData<Boolean> calificar;
    private MutableLiveData<Boolean> estado;
    private MutableLiveData<Pedido> pedido;


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

    public LiveData<List<Pedido>> getAllPedidosByUserId(final Long userId) {
        pedidos = new MutableLiveData<>();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                pedidoService.getAllPedidosByUserId(userId).enqueue(new Callback<List<Pedido>>() {
                    @Override
                    public void onResponse(Call<List<Pedido>> call, Response<List<Pedido>> response) {
                        pedidos.postValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Pedido>> call, Throwable t) {

                    }
                });
            }
        });
        return pedidos;
    }

    public LiveData<Pedido> getPedido(final long idPedido) {
        pedido = new MutableLiveData<>();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                pedidoService.getPedido(idPedido).enqueue(new Callback<Pedido>() {
                    @Override
                    public void onResponse(Call<Pedido> call, Response<Pedido> response) {
                        pedido.postValue(response.body());
                    }

                    @Override
                    public void onFailure(Call<Pedido> call, Throwable t) {
                        pedido.postValue(null);
                    }
                });
            }
        });
        return pedido;
    }

    public LiveData<Boolean> calificar(final String calificacion, final long idPedido) {
        calificar = new MutableLiveData<>();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                pedidoService.calificar(new CalificarRequest(calificacion, idPedido)).enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        calificar.postValue(true);
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        calificar.postValue(false);
                    }
                });
            }
        });
        return calificar;
    }

    public LiveData<Boolean> cambiarEstado(final long idPedido) {
        estado = new MutableLiveData<>();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                pedidoService.cambiarEstado(idPedido).enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if (response.body() != null && response.body()) {
                            estado.postValue(true);
                        } else {
                            estado.postValue(false);
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {

                    }
                });
            }
        });
        return estado;
    }
}
