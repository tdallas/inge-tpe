package com.inge.ingeapp.repository;

import com.inge.ingeapp.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    @Query("SELECT r from Restaurante r where r.nombre = :nombre")
    Restaurante findRestauranteByNombre(@Param("nombre") String nombre);
}
