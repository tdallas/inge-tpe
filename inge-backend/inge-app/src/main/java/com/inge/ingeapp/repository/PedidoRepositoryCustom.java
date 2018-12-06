package com.inge.ingeapp.repository;

import com.inge.ingeapp.entity.Estado;
import com.inge.ingeapp.entity.Pedido;

import java.util.List;

public interface PedidoRepositoryCustom {
    void updateEstadoPedido(Long idPedido, Estado estado);

    List<Pedido> findAllByUserId(Long idUser);
}
