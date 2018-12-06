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
public class Cliente extends Usuario {
    @OneToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Pedido> pedidosRealizados = new ArrayList<>();
    @Embedded
    private String direccion;

    public Cliente(String nombre, String apellido,
                   String email, String clave, Rol rol, String dni, String telefono) {
        super(nombre, apellido, email, clave, rol, dni, telefono);
    }

}
