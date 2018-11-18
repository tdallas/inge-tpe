package com.inge.ingeapp.repository;

import com.inge.ingeapp.entity.Estado;

import javax.persistence.Query;

public class PedidoRepositoryCustomImpl extends BaseRepositoryImpl implements PedidoRepositoryCustom {
    @Override
    public void updateEstadoPedido(Long idPedido, Estado estado) {
        String query = "UPDATE Pedido p SET p.estado = :estado WHERE p.id = :idPedido";
        Query query2 = entityManager.createQuery(query);
        query2.setParameter("estado", estado);
        query2.setParameter("idPedido", idPedido);
        query2.executeUpdate();
    }
}