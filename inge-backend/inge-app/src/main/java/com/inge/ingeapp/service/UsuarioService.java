package com.inge.ingeapp.service;

import com.inge.ingeapp.entity.*;
import com.inge.ingeapp.exception.SignupUserException;
import com.inge.ingeapp.controller.request.SignupRequest;
import com.inge.ingeapp.exception.UserNotFoundException;
import com.inge.ingeapp.repository.ClienteRepository;
import com.inge.ingeapp.repository.RolRepository;
import com.inge.ingeapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ClienteRepository clienteRepository;
    private final RolRepository rolRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, ClienteRepository clienteRepository,
                          RolRepository rolRepository){
        this.usuarioRepository = usuarioRepository;
        this.clienteRepository = clienteRepository;
        this.rolRepository = rolRepository;
    }

    public Usuario findByEmailAndPass(String email, String pass){
        return usuarioRepository.findByEmailAndPass(email, pass);
    }

    public void signup(SignupRequest signupRequest) throws SignupUserException {
        if (usuarioRepository.findByEmail(signupRequest.getEmail()).isPresent()) {
            throw new SignupUserException("El usuario ya fue registrado");
        } else {
            validarDatos(signupRequest);
            clienteRepository.save(parsearDatos(signupRequest));
        }
    }

    private Cliente parsearDatos(SignupRequest signupRequest) {
        Direccion direccion = parsearDireccion(signupRequest);
        Rol rol = rolRepository.findByNombre("CLIENTE");
        return new Cliente(direccion, signupRequest.getNombre(), signupRequest.getApellido(),
                signupRequest.getEmail(), signupRequest.getClave(), rol);
    }

    private Direccion parsearDireccion(SignupRequest signupRequest) {
        return new Direccion(signupRequest.getPais() ,
                signupRequest.getProvincia(), signupRequest.getLocalidad(),
                signupRequest.getCalle(), signupRequest.getNumero(), signupRequest.getCodigoPostal(),
                new Coordenadas());
    }

    //TODO
    private void validarDatos(SignupRequest signupRequest) throws SignupUserException {
    }

    public void invalidarUsuario(String emailToInvalidar) {
        usuarioRepository.invalidarUsuarioByEmail(emailToInvalidar);
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
}
