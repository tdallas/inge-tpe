package com.inge.ingeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Producto {
    private Long id;
    private String descripcion;
    private Double precio;
    private String imagenURL;
    private Tamaño tamaño;
}
