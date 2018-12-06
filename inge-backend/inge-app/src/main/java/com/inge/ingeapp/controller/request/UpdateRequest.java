package com.inge.ingeapp.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateRequest {

    private String mailActual;
    private String claveActual;
    private String mail;
    private String clave;
    private String telefono;
    private Long idUser;
    private String direcction;

    public UpdateRequest(String mail, String clave, String telefono, String direccion, Long idUser, String mailActual, String claveActual) {
        this.mail = mail;
        this.clave = clave;
        this.telefono = telefono;
        this.direcction = direccion;
        this.idUser = idUser;
        this.mailActual = mailActual;
        this.claveActual = claveActual;
    }
}
