package com.ingeapp.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido implements Serializable {
    @PrimaryKey
    private Long id;
    private Date horaRealizado;
    private Date horaEntrega;
    private Estado estado;
    private Cliente cliente;
    private List<Producto> productos = new ArrayList<>();
    private Calificacion calificacion;
    private String direccionEntrega;

    public Pedido(Long id, Date horaRealizado, Date horaEntrega, Estado estado,
                  Cliente cliente, List<Producto> productos, Calificacion calificacion,
                  String direccionEntrega) {
        this.id = id;
        this.horaRealizado = horaRealizado;
        this.horaEntrega = horaEntrega;
        this.estado = estado;
        this.cliente = cliente;
        this.productos = productos;
        this.calificacion = calificacion;
        this.direccionEntrega = direccionEntrega;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHoraRealizado() {
        return horaRealizado;
    }

    public void setHoraRealizado(Date horaRealizado) {
        this.horaRealizado = horaRealizado;
    }

    public Date getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(Date horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }
}
