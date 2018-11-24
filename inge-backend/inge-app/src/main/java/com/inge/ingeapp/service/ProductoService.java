package com.inge.ingeapp.service;

import com.inge.ingeapp.controller.request.ProductoRequest;
import com.inge.ingeapp.entity.Producto;
import com.inge.ingeapp.entity.TipoProducto;
import com.inge.ingeapp.exception.NewProductException;
import com.inge.ingeapp.repository.ProductoRepository;
import com.inge.ingeapp.repository.TipoProductoRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductoService {

    private final ProductoRepository productoRepository;
    private final TipoProductoRepository tipoProductoRepository;

    public ProductoService(ProductoRepository productoRepository, TipoProductoRepository tipoProductoRepository) {
        this.productoRepository = productoRepository;
        this.tipoProductoRepository = tipoProductoRepository;
    }

    public void cargarProducto(ProductoRequest productoRequest) throws NewProductException {
        validarDatos(productoRequest);
        TipoProducto tipoProducto = getTipoProducto(productoRequest.getTipoProducto());
        Producto producto = new Producto(productoRequest.getNombre(), productoRequest.getDetalles(),
                productoRequest.getPrecio(), tipoProducto, productoRequest.getTamanios());
        productoRepository.save(producto);
    }

    private TipoProducto getTipoProducto(String tipoProducto) {
        return tipoProductoRepository.findByNombre(tipoProducto);
    }

    private void validarDatos(ProductoRequest productoRequest) throws NewProductException {
        if (productoRepository.findByNombre(productoRequest.getNombre()).isPresent()) {
            throw new NewProductException("El producto ya existe!");
        }
    }
}
