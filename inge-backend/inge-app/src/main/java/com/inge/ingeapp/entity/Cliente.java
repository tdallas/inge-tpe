package com.inge.ingeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cliente extends Usuario {
    private List<Cliente> referidos;
    private List<Pedido> pedidosRealizados;
    private String idParaReferir;
    private Date fechaDeNacimiento;

    public void agregarReferido(Cliente cliente) {
        referidos.add(cliente);
    }
}
