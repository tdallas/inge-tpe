package com.inge.ingeapp.controller;

import com.inge.ingeapp.controller.request.PedidoRequest;
import com.inge.ingeapp.entity.Pedido;
import com.inge.ingeapp.exception.PedidoNotFoundException;
import com.inge.ingeapp.exception.UserNotFoundException;
import com.inge.ingeapp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

    PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


    @RequestMapping(value = "/pedido/crear")
    public ResponseEntity<?> crearPedido(@RequestBody PedidoRequest pedidoRequest) {
        if (pedidoRequest == null) {
            return ResponseEntity.badRequest().build();
        } else {
            try {
                Pedido pedido = pedidoService.crearPedido(pedidoRequest.getProductos(),
                        pedidoRequest.getIdCliente(), pedidoRequest.getDireccionEntrega());
                return new ResponseEntity<>(pedido, HttpStatus.OK);
            } catch (UserNotFoundException e) {
                return ResponseEntity.notFound().build();
            }
        }
    }

    @RequestMapping(value = "/pedido/estado")
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