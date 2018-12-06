package com.ingeapp.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.List;

@Entity
public class Producto implements Serializable {
    @PrimaryKey
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
    private List<Tamanio> tamanios;

    public Producto(Long id, String nombre, String detalles, Double precio, Integer cantidadVendidos, List<Tamanio> tamanios) {
        this.id = id;
        this.nombre = nombre;
        this.detalles = detalles;
        this.precio = precio;
        this.cantidadVendidos = cantidadVendidos;
        this.tamanios = tamanios;
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

    public Integer getCantidadVendidos() {
        return cantidadVendidos;
    }

    public void setCantidadVendidos(Integer cantidadVendidos) {
        this.cantidadVendidos = cantidadVendidos;
    }

    public List<Tamanio> getTamanios() {
        return tamanios;
    }

    public void setTamanios(List<Tamanio> tamanios) {
        this.tamanios = tamanios;
    }
}
