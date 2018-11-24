package com.inge.ingeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Restaurante extends Usuario {

    @OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY)
    private List<Pedido> productosPorRealizar;

    public Restaurante(String nombre, String apellido, String email,
                       String clave, Rol rol, String dni, String telefono) {
        super(nombre, apellido, email, clave, rol, dni, telefono);
    }

}
