package com.inge.ingeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public abstract class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descripcion;
    private Double precio;
    private String imagenURL;
    private Tamaño tamaño;
}
