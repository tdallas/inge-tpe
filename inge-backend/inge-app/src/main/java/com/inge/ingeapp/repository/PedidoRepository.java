package com.inge.ingeapp.repository;

import com.inge.ingeapp.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
