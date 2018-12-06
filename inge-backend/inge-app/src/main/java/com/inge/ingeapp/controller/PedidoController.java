package com.inge.ingeapp.controller;

import com.inge.ingeapp.controller.request.CalificarRequest;
import com.inge.ingeapp.controller.request.PedidoRequest;
import com.inge.ingeapp.entity.Pedido;
import com.inge.ingeapp.exception.PedidoNotFoundException;
import com.inge.ingeapp.exception.UserNotFoundException;
import com.inge.ingeapp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PedidoController {

    PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


    @PostMapping(value = "/pedido/crear")
    @ResponseBody
    public ResponseEntity<?> crearPedido(@RequestBody PedidoRequest pedidoRequest) {
        if (pedidoRequest == null) {
            return ResponseEntity.badRequest().build();
        } else {
            try {
                Pedido pedido = pedidoService.crearPedido(pedidoRequest.getProductos(),
                        pedidoRequest.getIdCliente(), pedidoRequest.getDireccion());
                return new ResponseEntity<>(pedido, HttpStatus.OK);
            } catch (UserNotFoundException e) {
                return ResponseEntity.notFound().build();
            }
        }
    }

    @GetMapping(value = "/getAllPedidos")
    @ResponseBody
    public ResponseEntity<?> getAllPedidos() {
        return new ResponseEntity<>(pedidoService.findAllPedidos(), HttpStatus.OK);
    }

    @GetMapping(value = "/getAllPedidos/{idUser}")
    @ResponseBody
    public ResponseEntity<?> getAllPedidos(@PathVariable Long idUser) {
        return new ResponseEntity<>(pedidoService.findAllPedidosById(idUser), HttpStatus.OK);
    }

    @PostMapping(value = "/calificar")
    @ResponseBody
    public ResponseEntity<?> calificar(@RequestBody CalificarRequest calificarRequest) {
        return new ResponseEntity<>(pedidoService.calificar(calificarRequest), HttpStatus.OK);
    }

    @GetMapping(value = "/getPedido/{id}")
    @ResponseBody
    public ResponseEntity<?> getPedidoById(@PathVariable Long id) {
        return new ResponseEntity<>(pedidoService.getPedidoById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/pedido/estado")
    @ResponseBody
    public ResponseEntity<?> cambiarEstadoPedido(@RequestBody EstadoPedidoRequest estadoPedidoRequest) {
        if (estadoPedidoRequest == null) {
            return ResponseEntity.badRequest().build();
        } else {
            try {
                pedidoService.cambiarEstadoPedido(estadoPedidoRequest.getIdPedido(), estadoPedidoRequest.getEstado());
                return new ResponseEntity<>("Se cambio el estado del pedido correctamente", HttpStatus.OK);
            } catch (PedidoNotFoundException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }

    //TODO si queda tiempo implementar la modificacion del pedido, por ahora no
}
