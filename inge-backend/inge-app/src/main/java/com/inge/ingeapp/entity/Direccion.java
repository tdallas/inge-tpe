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
    private String calle;
    private String numero;
    private String piso;
    private String depto;
    @Embedded
    private Coordenadas coordenadas;

}
