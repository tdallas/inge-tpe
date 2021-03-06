package com.ingeapp.model.viewModel;

import android.arch.lifecycle.LiveData;

import com.ingeapp.dagger.components.IngeComponents;
import com.ingeapp.db.PedidoRepository;
import com.ingeapp.model.entities.Pedido;

import javax.inject.Inject;

public class DetallePedidoRestauranteViewModel extends IngeViewModel {

    @Inject
    PedidoRepository pedidoRepository;

    @Override
    public void initialize(IngeComponents component) {
        component.inject(this);
    }

    public LiveData<Pedido> getPedido(long idPedido) {
       return pedidoRepository.getPedido(idPedido);
    }

    public LiveData<Boolean> cambiarEstado(long idPedido) {
        return pedidoRepository.cambiarEstado(idPedido);
    }
}
