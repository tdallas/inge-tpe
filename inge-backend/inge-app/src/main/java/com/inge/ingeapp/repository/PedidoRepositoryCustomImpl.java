package com.inge.ingeapp.repository;

import com.inge.ingeapp.entity.Estado;
import com.inge.ingeapp.entity.Pedido;

import javax.persistence.Query;
import java.util.List;

public class PedidoRepositoryCustomImpl extends BaseRepositoryImpl implements PedidoRepositoryCustom {
    @Override
    public void updateEstadoPedido(Long idPedido, Estado estado) {
        String query = "UPDATE Pedido p SET p.estado = :estado WHERE p.id = :idPedido";
        Query query2 = entityManager.createQuery(query);
        query2.setParameter("estado", estado);
        query2.setParameter("idPedido", idPedido);
        query2.executeUpdate();
    }

    @Override
    public List<Pedido> findAllByUserId(Long idUser) {
        String query = "SELECT p FROM Pedido p WHERE p.cliente.id = :idUser";
        Query query1 = entityManager.createQuery(query);
        query1.setParameter("idUser", idUser);
        return query1.getResultList();
    }
}