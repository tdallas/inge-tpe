package com.inge.ingeapp.repository;

import com.inge.ingeapp.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
