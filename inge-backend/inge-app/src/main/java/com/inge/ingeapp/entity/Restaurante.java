package com.inge.ingeapp.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@Entity
@AllArgsConstructor
public class Restaurante extends Usuario {

    private List<Producto> productosPorRealizar;
    private List<Calificacion> calificaciones;

}
