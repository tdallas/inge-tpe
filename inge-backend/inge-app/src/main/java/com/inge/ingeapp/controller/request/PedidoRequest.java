package com.inge.ingeapp.controller.request;

import com.inge.ingeapp.entity.Direccion;
import com.inge.ingeapp.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PedidoRequest {
    private List<Producto> productos;
    private Long idCliente;
    private String direccion;
}
