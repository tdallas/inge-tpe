package com.inge.ingeapp.controller;

import com.inge.ingeapp.controller.request.UpdateRequest;
import com.inge.ingeapp.service.ClienteService;
import com.inge.ingeapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    private final ClienteService clienteService;
    private final UsuarioService usuarioService;

    @Autowired
    public ClienteController(ClienteService clienteService, UsuarioService usuarioService){
        this.clienteService = clienteService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<?> updateUserInfo(@RequestBody UpdateRequest updateRequest) {
        boolean update = usuarioService.updateInfo(updateRequest);
        if (!update)
            return new ResponseEntity<>(false, HttpStatus.OK);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
