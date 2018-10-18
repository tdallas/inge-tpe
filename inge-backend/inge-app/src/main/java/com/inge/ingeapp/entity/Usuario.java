package com.inge.ingeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public abstract class Usuario {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private Rol rol;
    private Direccion direccion;

}
