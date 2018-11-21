package com.inge.ingeapp.repository;

import com.inge.ingeapp.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    @Query("SELECT R from Restaurante where id = 1")
    Restaurante findRestaurante();
}
