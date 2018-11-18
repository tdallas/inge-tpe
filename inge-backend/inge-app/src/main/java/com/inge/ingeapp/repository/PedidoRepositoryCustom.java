package com.inge.ingeapp.repository;

import com.inge.ingeapp.entity.Estado;

public interface PedidoRepositoryCustom {
    void updateEstadoPedido(Long idPedido, Estado estado);
}
