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
     * Nombre sería si es pizza, bebida o lo que sea
     */
    private String nombre;
    /**
     * En detalles iría marca y tipo si fuese bebida o ingredientes si fuese pizza
     */
    private String detalles;
    private Double precio;
    private String imagenURL;
    @Embedded
    private List<Tamaño> tamanios = new ArrayList<>();
}
