package com.ingeapp.model.viewModel;

import android.arch.lifecycle.LiveData;

import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.db.PedidoRepository;
import com.ingeapp.db.ProductoRepository;
import com.ingeapp.model.entities.Producto;
import com.ingeapp.service.payload.PedidoRequest;

import java.util.List;

import javax.inject.Inject;

public class CrearPedidoViewModel extends IngeViewModel {

    @Inject
    ProductoRepository productoRepository;
    @Inject
    PedidoRepository pedidoRepository;

    @Override
    public void initialize(IngeComponents component) {
        component.inject(this);
    }

    public LiveData<List<Producto>> getAllProductos() {
        return productoRepository.getAllProductos();
    }

    public LiveData<Boolean> crearPedido(PedidoRequest pedidoRequest) {
        return pedidoRepository.crearPedido(pedidoRequest);
    }
}
