package com.inge.ingeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private Integer cantidadVendidos = 0;
    @Embedded
    private List<Tamanio> tamanios = new ArrayList<>();

    public Producto(String nombre, String detalles, Double precio, List<Tamanio> tamanios) {
        this.nombre = nombre;
        this.detalles = detalles;
        this.precio = precio;
        this.tamanios = tamanios;
    }
}
