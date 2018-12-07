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
    private String estado;
    private Cliente cliente;
    private List<Compra> productos = new ArrayList<>();
    private String calificacion;
    private String direccionEntrega;
    private Double precio;

    public Double getPrecio() {
        return precio;
    }

    public Pedido(Long id, Date horaRealizado, Date horaEntrega, String estado,
                  Cliente cliente, List<Compra> productos, String calificacion,
                  String direccionEntrega, Double precio) {
        this.id = id;
        this.horaRealizado = horaRealizado;
        this.horaEntrega = horaEntrega;
        this.estado = estado;
        this.cliente = cliente;
        this.productos = productos;
        this.calificacion = calificacion;
        this.precio = precio;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Compra> getProductos() {
        return productos;
    }

    public void setProductos(List<Compra> productos) {
        this.productos = productos;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }
}
