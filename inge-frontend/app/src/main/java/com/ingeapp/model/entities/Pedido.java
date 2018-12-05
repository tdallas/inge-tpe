package com.ingeapp.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido implements Serializable {
    @PrimaryKey
    private Long id;
    private List<Producto> productos;
    private Usuario usuario;
    private Date fechaRealizado;
    private Date fechaEntrega;
    private String estado;

    public Pedido() {
    }

    public Pedido(Long id, List<Producto> productos, Usuario usuario, Date fechaRealizado, Date fechaEntrega, String estado) {
        this.id = id;
        this.productos = productos;
        this.usuario = usuario;
        this.fechaRealizado = fechaRealizado;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaRealizado() {
        return fechaRealizado;
    }

    public void setFechaRealizado(Date fechaRealizado) {
        this.fechaRealizado = fechaRealizado;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
