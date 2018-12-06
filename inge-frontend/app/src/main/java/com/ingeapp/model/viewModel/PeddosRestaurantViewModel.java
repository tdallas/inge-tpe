package com.ingeapp.model.viewModel;

import android.arch.lifecycle.LiveData;

import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.db.PedidoRepository;
import com.ingeapp.model.entities.Pedido;

import java.util.List;

import javax.inject.Inject;

public class PeddosRestaurantViewModel extends IngeViewModel {

    @Inject
    PedidoRepository pedidoRepository;

    @Override
    public void initialize(IngeComponents component) {
        component.inject(this);
    }

    public LiveData<List<Pedido>> getAllPedidos() { return pedidoRepository.getAllPedidos(); }
}
