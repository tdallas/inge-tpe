package com.ingeapp.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Producto implements Serializable {
    @PrimaryKey
    private Long id;
    private String descripcion;
    private Double precio;

    public Producto(Long id, String descripcion, Double precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Producto() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
