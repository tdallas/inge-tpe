package com.ingeapp.model.request;

public class LoginRequest {
    private String usuario;
    private String clave;

    public LoginRequest(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
}
