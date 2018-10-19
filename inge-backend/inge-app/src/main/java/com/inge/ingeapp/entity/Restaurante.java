package com.inge.ingeapp.entity;

import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
public class Restaurante extends Usuario {

    @OneToMany
    private List<Producto> productosPorRealizar;
    @OneToMany
    private List<Calificacion> calificaciones;

}
