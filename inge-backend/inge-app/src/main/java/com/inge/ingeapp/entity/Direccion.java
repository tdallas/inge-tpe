package com.inge.ingeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Direccion {

    private String calle;
    private String numero;
    private String piso;
    private String depto;
    private Coordenadas coordenadas;

}
