package com.inge.ingeapp.entity;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Embeddable
public enum Estado {
    ENTREGADO, ENCOLA, PROCESANDO, PREPARANDO, ENESPERA
}
