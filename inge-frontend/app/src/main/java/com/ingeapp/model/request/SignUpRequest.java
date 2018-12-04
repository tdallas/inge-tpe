package com.ingeapp.model.request;

public class SignUpRequest {

    private String email;
    private String clave;
    private String nombre;
    private String apellido;
    private String DNI;
    private String telefono;

    public SignUpRequest(String email, String clave, String dni, String telefono, String nombre, String apellido) {
        this.email = email;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = dni;
        this.telefono = telefono;
    }
}
