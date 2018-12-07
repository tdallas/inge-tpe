package com.ingeapp.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Compra {
    public Long getId() {
        return id;
    }

    @PrimaryKey
    private Long id;
    private Producto producto;
    private Integer cantidad = 0;

    public Compra(Producto p, Integer cantidad) {
        this.producto = p;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
