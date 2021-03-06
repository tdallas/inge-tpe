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
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    List<Usuario> usuarios;

    public Rol(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
