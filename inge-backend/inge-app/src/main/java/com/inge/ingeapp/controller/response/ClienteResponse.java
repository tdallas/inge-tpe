package com.inge.ingeapp.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse {
    String email;
    String nombreYApellido;
    String DNI;
    boolean verificado;
}
