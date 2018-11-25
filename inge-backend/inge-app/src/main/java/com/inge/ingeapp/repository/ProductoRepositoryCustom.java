package com.inge.ingeapp.repository;

import com.inge.ingeapp.entity.Producto;

import java.util.List;

public interface ProductoRepositoryCustom {
    List<Producto> findAllByTipo(String tipo);
}
