package com.inge.ingeapp.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class SignUpRequest {
    private String email;
    private String clave;
    private String nombre;
    private String apellido;
    private String DNI;
    private String telefono;
}


