package com.inge.ingeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tamanio {

    private Long id;
    private String tamaño;
    @OneToMany
    private Pedido pedido;
    @OneToMany
    private Producto producto;

}
