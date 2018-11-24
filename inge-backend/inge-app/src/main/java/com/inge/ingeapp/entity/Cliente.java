package com.inge.ingeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cliente extends Usuario {
    @OneToMany
    private List<Cliente> referidos = new ArrayList<>();
    @OneToMany
    private List<Pedido> pedidosRealizados = new ArrayList<>();
    //todo autogenerar
    private String idParaReferir;
    @Embedded
    private Direccion direccion;

    public Cliente(Direccion direccion, String nombre, String apellido,
                   String email, String clave, Rol rol) {
        super(nombre, apellido, email, clave, rol);
        this.direccion = direccion;
    }

    public void agregarReferido(Cliente cliente) {
        referidos.add(cliente);
    }
}
