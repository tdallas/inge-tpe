package com.inge.ingeapp.controller;

import com.inge.ingeapp.entity.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EstadoPedidoRequest {
    private Long idPedido;
    private Estado estado;
}
