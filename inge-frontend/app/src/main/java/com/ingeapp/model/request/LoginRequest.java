package com.ingeapp.model.request;

import com.ingeapp.db.LoginRepository;

public class LoginRequest {
    private String usuario;
    private String clave;

    public LoginRequest(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
}
