package com.ingeapp.model.entities;

import android.arch.persistence.room.Entity;

public class Tamanio {
    private String tamaño;
    private boolean elegido = false;

    public Tamanio(String tamaño, boolean elegido) {
        this.tamaño = tamaño;
        this.elegido = elegido;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public boolean isElegido() {
        return elegido;
    }

    public void setElegido(boolean elegido) {
        this.elegido = elegido;
    }
}
