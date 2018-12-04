package com.inge.ingeapp.repository;

import com.inge.ingeapp.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepositoryCustom {
    Usuario findByEmailAndClave(String email, String pass);

    Optional<Usuario> findByEmail(String email);
}
