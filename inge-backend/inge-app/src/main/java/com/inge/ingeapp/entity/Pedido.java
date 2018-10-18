package com.inge.ingeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    private Estado estado;
    private Usuario usuario;
    private List<Producto> productos = new ArrayList<>();
    private Calificacion calificacion;
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
