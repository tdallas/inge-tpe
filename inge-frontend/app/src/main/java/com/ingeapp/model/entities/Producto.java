package com.ingeapp.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
public class Producto implements Serializable {
    @PrimaryKey
    private Long id;
    private String nombre;
    private String detalles;
    private Double precio;
    //-1 significa que todavia no fue calificado por nadie
    private Integer cantidad = 0;

    public Producto(Long id, String nombre, String detalles, Double precio, Integer cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.detalles = detalles;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
