package com.inge.ingeapp.controller.request;

import com.inge.ingeapp.entity.Tamanio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoRequest {
    private String nombre;
    private String detalles;
    private Double precio;
    private String tipoProducto;
    private List<Tamanio> tamanios;
}
