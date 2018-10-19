package com.inge.ingeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date horaRealizado;

    private Date horaEntrega;

    @Embedded
    private Estado estado;

    private Usuario usuario;

    @OneToMany
    private List<Producto> productos = new ArrayList<>();

    @Embedded
    private Calificacion calificacion;

    @OneToMany
    private Direccion direccionEntrega;

    private String comentario;

    public Double getPrecioTotal() {
        if (productos.size() != 0) {
            Double precioFinal = 0d;
            for (Producto p : productos)
                precioFinal += p.getPrecio();
        }
        return null;
    }

}
