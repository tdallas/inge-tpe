package com.inge.ingeapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String estado;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Compra> productos = new ArrayList<>();

    private String calificacion = "";

    private String direccionEntrega;

    @JsonIgnore
    @ManyToOne
    private Restaurante restaurante;

    private Double precio = getPrecioTotal();

    public Double getPrecioTotal() {
        if (productos.size() != 0) {
            Double precioFinal = 0d;
            for (Compra c : productos)
                precioFinal += c.getProducto().getPrecio() * c.getCantidad();
            return precioFinal;
        }
        return 0D;
    }

}
