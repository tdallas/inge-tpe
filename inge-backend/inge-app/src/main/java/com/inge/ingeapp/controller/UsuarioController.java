package com.inge.ingeapp.controller;

import com.inge.ingeapp.controller.request.LoginRequest;
import com.inge.ingeapp.controller.response.ClienteResponse;
import com.inge.ingeapp.controller.response.UserResponse;
import com.inge.ingeapp.entity.Cliente;
import com.inge.ingeapp.exception.SignupUserException;
import com.inge.ingeapp.controller.request.SignUpRequest;
import com.inge.ingeapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController implements CommandLineRunner {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String rol = loginRequest.getEmail().equals("admin@admin.com") ? "RESTAURANTE" : "CLIENTE";
        return usuarioService.findByEmailAndPass(loginRequest.getEmail(), loginRequest.getClave()) ?
                new ResponseEntity<>(new UserResponse(true, rol), HttpStatus.OK) : new ResponseEntity<>(new UserResponse(false, rol), HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/signup")
    @ResponseBody
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signupRequest) {
        try {
            usuarioService.signup(signupRequest);
            return new ResponseEntity<>(new UserResponse(true, ""), HttpStatus.OK);
        } catch (SignupUserException s) {
            return new ResponseEntity<>(new UserResponse(false, ""), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/invalidarUsuario")
    @ResponseBody
    public ResponseEntity<?> invalidarUsuario(@RequestBody String emailToInvalidar) {
        usuarioService.invalidarUsuario(emailToInvalidar);
        return ResponseEntity.ok("El usuario se invalido con exito");
    }

    @GetMapping(value = "/getUsuarios")
    @ResponseBody
    public ResponseEntity<?> getAllClientes()  {
        List<Cliente> clientes = usuarioService.getAllClientes();
        return new ResponseEntity<>(parsearClientes(clientes), HttpStatus.OK);
    }

    private List<ClienteResponse> parsearClientes(List<Cliente> clientes) {
        List<ClienteResponse> clientesResponse = new ArrayList<>();
        for (Cliente c : clientes) {
            clientesResponse.add(new ClienteResponse(c.getEmail(), c.getNombre()+c.getApellido(),
                    c.getDNI(), c.isVerificado()));
        }
        return clientesResponse;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
