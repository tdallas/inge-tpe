package com.inge.ingeapp.entity;

import javax.persistence.Entity;

@Entity
public enum Estado {
    ENTREGADO, ENCOLA, PROCESANDO, PREPARANDO, ENESPERA
}
