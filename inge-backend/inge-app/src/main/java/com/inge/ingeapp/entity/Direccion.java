package com.inge.ingeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Direccion {
    private String pais;
    private String Provincia;
    private String localidad;
    private String calle;
    private String numero;
    private String codigoPostal;
    @Embedded //de baja x ahora
    private Coordenadas coordenadas;

}
