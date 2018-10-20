package com.inge.ingeapp.controller;

import com.inge.ingeapp.entity.Usuario;
import com.inge.ingeapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @RequestMapping(value="/login")
    @ResponseBody
    public Usuario getUsuario(@RequestParam("email") String email, @RequestParam("pass") String pass){
        return usuarioService.findByEmailAndPass(email, pass);
    }
}
