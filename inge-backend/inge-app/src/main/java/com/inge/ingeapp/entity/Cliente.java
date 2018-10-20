package com.inge.ingeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cliente extends Usuario {
    @OneToMany
    private List<Cliente> referidos;
    @OneToMany
    private List<Pedido> pedidosRealizados;
    private String idParaReferir;
    private Date fechaDeNacimiento;
    @Embedded
    private Direccion direccion;

    public void agregarReferido(Cliente cliente) {
        referidos.add(cliente);
    }
}