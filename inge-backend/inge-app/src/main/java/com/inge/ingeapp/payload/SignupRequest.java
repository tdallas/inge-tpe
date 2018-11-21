package com.inge.ingeapp.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class SignupRequest {
    private String email;
    private String clave;
    private String direccion;
    private String telefonoCelular;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
}
