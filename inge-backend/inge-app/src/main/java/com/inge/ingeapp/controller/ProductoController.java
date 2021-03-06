package com.inge.ingeapp.controller;

import com.inge.ingeapp.controller.request.ProductoRequest;
import com.inge.ingeapp.entity.Producto;
import com.inge.ingeapp.entity.TipoProducto;
import com.inge.ingeapp.exception.NewProductException;
import com.inge.ingeapp.exception.ProductException;
import com.inge.ingeapp.repository.ProductoRepository;
import com.inge.ingeapp.repository.TipoProductoRepository;
import com.inge.ingeapp.service.ProductoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class ProductoController implements CommandLineRunner {

    private final TipoProductoRepository tipoProductoRepository;
    private final ProductoService productoService;
    private final ProductoRepository productoRepository;

    public ProductoController(TipoProductoRepository tipoProductoRepository,
                              ProductoService productoService,
                              ProductoRepository productoRepository) {
        this.tipoProductoRepository = tipoProductoRepository;
        this.productoService = productoService;
        this.productoRepository = productoRepository;
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

    @GetMapping(value = "/getProducto/{id}")
    @ResponseBody
    public ResponseEntity<?> getProductoById(@PathVariable Long id) {
        return new ResponseEntity<>(productoService.getProductoById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getAllProductos")
    @ResponseBody
    public ResponseEntity<?> getAllProductos() {
        try {
            List<Producto> productos = productoService.getAllProductos();
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<>("No se encontraron productos", HttpStatus.OK);
        }
    }

    @GetMapping(value = "/getAllProductosByTipo")
    @ResponseBody
    public ResponseEntity<?> getAllProductosByTipo(@RequestParam String tipo) {
        try {
            List<Producto> productos = productoService.getAllProductos(tipo);
            return new ResponseEntity<>(productos, HttpStatus.OK);
        } catch(ProductException e) {
            return new ResponseEntity<>("No se encontraron productos del tipo " + tipo, HttpStatus.OK);
        }
    }

    //ACA VOY A CARGAR EN LA BASE TODOS LOS PRODUCTOS
    @Override
    public void run(String... args) throws Exception {
        if (productoRepository.findByNombre("Pizza").isPresent())
            return;
        Producto pizzaProducto = new Producto("Pizza", "Pizza de muzzarella", 123.50d);
        Producto pizza2Producto = new Producto("Pizza", "Pizza doble muzzarella", 153.50d);
        Producto pizza3Producto = new Producto("Pizza", "Pizza de palmitos", 183.50d);
        Producto pizza4Producto = new Producto("Pizza", "Pizza hawaianna", 200.50d);
        Producto pizza5Producto = new Producto("Pizza", "Pizza calabresa", 250.50d);
        Producto empanada = new Producto("Empanada", "Empanada de carne", 15d);
        Producto empanada2 = new Producto("Empanada", "Empanada de pollo", 15d);
        Producto empanada3 = new Producto("Empanada", "Empanada de jamon y queso", 10d);
        Producto bebida = new Producto("Bebida", "Coca cola", 70d);
        Producto cerveza = new Producto("Bebida", "Cerveza quilmes", 60d);
        Producto bebida2 = new Producto("Bebida", "Fernet + coca", 100d);
        productoRepository.save(empanada);
        productoRepository.save(empanada2);
        productoRepository.save(empanada3);
        productoRepository.save(bebida);
        productoRepository.save(bebida2);
        productoRepository.save(cerveza);
        productoRepository.save(pizzaProducto);
        productoRepository.save(pizza2Producto);
        productoRepository.save(pizza3Producto);
        productoRepository.save(pizza4Producto);
        productoRepository.save(pizza5Producto);

    }
}
