package com.inge.ingeapp.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CalificarRequest {
    private String calificacion;
    private Long idPedido;
}
