package com.ingeapp.service.payload;

import com.ingeapp.model.entities.Producto;

import java.util.List;

public class PedidoRequest {
    private List<Producto> productos;
    private Long idCliente;
    private String direccion;

    public PedidoRequest(List<Producto> productos, Long idCliente, String direccion) {
        this.productos = productos;
        this.idCliente = idCliente;
        this.direccion = direccion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
