package com.inge.ingeapp.controller;

import com.inge.ingeapp.controller.request.ProductoRequest;
import com.inge.ingeapp.entity.TipoProducto;
import com.inge.ingeapp.exception.NewProductException;
import com.inge.ingeapp.repository.TipoProductoRepository;
import com.inge.ingeapp.service.ProductoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController implements CommandLineRunner {

    private final TipoProductoRepository tipoProductoRepository;
    private final ProductoService productoService;

    public ProductoController(TipoProductoRepository tipoProductoRepository, ProductoService productoService) {
        this.tipoProductoRepository = tipoProductoRepository;
        this.productoService = productoService;
    }

    @PostMapping(value = "/nuevoProducto")
    @ResponseBody
    public ResponseEntity<?> cargarNuevoProducto(@RequestBody ProductoRequest productoRequest) {
        try {
            productoService.cargarProducto(productoRequest);
            return new ResponseEntity<>("¡Producto cargado con éxito!", HttpStatus.OK);
        } catch (NewProductException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    //ACA VOY A CARGAR EN LA BASE TODOS LOS PRODUCTOS
    @Override
    public void run(String... args) throws Exception {
        if (tipoProductoRepository.findById(1L).isPresent())
            return;
        TipoProducto pizza = new TipoProducto(1L, "PIZZA");
        TipoProducto gaseosa = new TipoProducto(2L, "GASEOSA");
        TipoProducto cerveza = new TipoProducto(3L, "CERVEZA");
        TipoProducto empanada = new TipoProducto(4L, "EMPANADA");
        tipoProductoRepository.save(pizza);
        tipoProductoRepository.save(gaseosa);
        tipoProductoRepository.save(cerveza);
        tipoProductoRepository.save(empanada);
    }
}
