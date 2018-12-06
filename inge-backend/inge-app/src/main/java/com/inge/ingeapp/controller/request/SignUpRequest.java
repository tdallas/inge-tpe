package com.inge.ingeapp.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SignUpRequest {
    private String email;
    private String clave;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String direccion;
}


