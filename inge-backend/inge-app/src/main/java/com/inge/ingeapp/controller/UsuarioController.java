package com.inge.ingeapp.controller;

import com.inge.ingeapp.entity.Usuario;
import com.inge.ingeapp.exception.SignupUserException;
import com.inge.ingeapp.payload.SignupRequest;
import com.inge.ingeapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @RequestMapping(value="/login")
    @ResponseBody
    public Usuario login(@RequestParam("email") String email, @RequestParam("pass") String pass){
        return usuarioService.findByEmailAndPass(email, pass);
    }

    @RequestMapping(value = "/signup")
    @ResponseBody
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        try {
            usuarioService.signup(signupRequest);
            return ResponseEntity.ok("Usuario regitrado con exito");
        } catch (SignupUserException s) {
            return new ResponseEntity<>(s.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
