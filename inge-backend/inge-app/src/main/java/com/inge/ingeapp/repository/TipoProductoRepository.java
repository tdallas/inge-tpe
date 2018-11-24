package com.inge.ingeapp.repository;

import com.inge.ingeapp.entity.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long> {
    TipoProducto findByNombre(String nombre);
}
