package com.inge.ingeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Pizza calabresa por ej
     */
    private String nombre;
    /**
     * En detalles iría marca y tipo si fuese bebida o ingredientes si fuese pizza
     */
    private String detalles;
    private Double precio;
    //-1 significa que todavia no fue calificado por nadie
    private Integer cantidad = 0;

    public Producto(String nombre, String detalles, Double precio) {
        this.nombre = nombre;
        this.detalles = detalles;
        this.precio = precio;
    }
}
