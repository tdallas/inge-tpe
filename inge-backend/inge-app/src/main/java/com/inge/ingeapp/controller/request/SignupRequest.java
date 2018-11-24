package com.inge.ingeapp.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class SignupRequest {
    private String email;
    private String clave;
    private String nombre;
    private String apellido;
    private String DNI;
    private String pais;
    private String provincia;
    private String Localidad;
    private String calle;
    private String numero;
    private String codigoPostal;
    private String telefono;
}


