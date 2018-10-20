package com.inge.ingeapp.repository;

import com.inge.ingeapp.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {
}
