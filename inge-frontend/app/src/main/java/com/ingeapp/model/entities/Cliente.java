package com.ingeapp.model.entities;

import android.arch.persistence.room.Entity;

@Entity
public class Cliente extends Usuario {
    private String direccion;

    public Cliente(Long id, String nombre, String apellido, String email,
                   String clave, Rol rol, String dni, String telefono, String direccion) {
        super(id, nombre, apellido, email, clave, rol, dni, telefono);
        this.direccion = direccion;
    }

    public Cliente(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
