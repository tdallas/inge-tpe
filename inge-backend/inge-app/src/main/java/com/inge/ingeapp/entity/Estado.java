package com.inge.ingeapp.entity;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;

public enum Estado {
    PROCESANDO, ENTREGANDO, ENTREGADO
}
