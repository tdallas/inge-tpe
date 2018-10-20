package com.inge.ingeapp.service;

import com.inge.ingeapp.entity.Usuario;
import com.inge.ingeapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario findByEmailAndPass(String email, String pass){
        return usuarioRepository.findByEmailAndPass(email, pass);
    }
}
