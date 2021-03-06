package com.inge.ingeapp.service;

import com.inge.ingeapp.controller.request.UpdateRequest;
import com.inge.ingeapp.entity.*;
import com.inge.ingeapp.exception.SignupUserException;
import com.inge.ingeapp.controller.request.SignUpRequest;
import com.inge.ingeapp.repository.ClienteRepository;
import com.inge.ingeapp.repository.RolRepository;
import com.inge.ingeapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        Usuario usuario = usuarioRepository.findByEmailAndClave(email, pass);
        return usuario;
    }

    public Cliente signup(SignUpRequest signupRequest) throws SignupUserException {
        if (usuarioRepository.findByEmail(signupRequest.getEmail()).isPresent()) {
            throw new SignupUserException("El usuario ya fue registrado");
        } else {
            validarDatos(signupRequest);
            return clienteRepository.save(parsearDatos(signupRequest));
        }
    }

    private Cliente parsearDatos(SignUpRequest signupRequest) {
        Rol rol = rolRepository.findByNombre("CLIENTE");
        return new Cliente(signupRequest.getNombre(), signupRequest.getApellido(),
                signupRequest.getEmail(), signupRequest.getClave(), rol,
                signupRequest.getDni(), signupRequest.getTelefono(), signupRequest.getDireccion());
    }

    //TODO
    private void validarDatos(SignUpRequest signupRequest) throws SignupUserException {
    }

    public void invalidarUsuario(String emailToInvalidar) {
        usuarioRepository.invalidarUsuarioByEmail(emailToInvalidar);
    }

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Transactional
    public boolean updateInfo(UpdateRequest updateRequest) {
        if (findByEmailAndPass(updateRequest.getMailActual(), updateRequest.getClaveActual()) == null) {
            return false;
        }
        clienteRepository.updateUser(updateRequest);
        return true;
    }
}
