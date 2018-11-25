package com.inge.ingeapp.repository;

import com.inge.ingeapp.entity.Producto;

import javax.persistence.Query;
import java.util.List;

public class ProductoRepositoryCustomImpl extends BaseRepositoryImpl implements ProductoRepositoryCustom {
    @Override
    public List<Producto> findAllByTipo(String tipo) {
        String hql = "SELECT Producto p FROM producto WHERE p.tipoProducto.nombre = :tipo";
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }
}
