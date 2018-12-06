package com.inge.ingeapp.service;

import com.inge.ingeapp.controller.request.ProductoRequest;
import com.inge.ingeapp.entity.Producto;
import com.inge.ingeapp.entity.TipoProducto;
import com.inge.ingeapp.exception.NewProductException;
import com.inge.ingeapp.exception.ProductException;
import com.inge.ingeapp.repository.ProductoRepository;
import com.inge.ingeapp.repository.TipoProductoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        Producto producto = new Producto(productoRequest.getNombre(), productoRequest.getDetalles(),
                productoRequest.getPrecio());
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

    public List<Producto> getAllProductos() throws ProductException{
        Optional<List<Producto>> optionalProductos = Optional.of(productoRepository.findAll());
        if (!optionalProductos.isPresent() || optionalProductos.get().size() == 0) {
            throw new ProductException("No se encontraron productos");
        }
        return optionalProductos.get();
    }

    public List<Producto> getAllProductos(String tipo) throws ProductException {
        Optional<List<Producto>> optionalProductos = Optional.of(productoRepository.findAllByTipo(tipo));
        if (!optionalProductos.isPresent() || optionalProductos.get().size() == 0) {
            throw new ProductException("No se encontraron productos");
        }
        return optionalProductos.get();
    }

    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).get();
    }
}
