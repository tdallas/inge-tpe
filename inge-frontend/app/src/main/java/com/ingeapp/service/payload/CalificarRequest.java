package com.ingeapp.service.payload;

public class CalificarRequest {
    private long idPedido;
    private String calificacion;

    public CalificarRequest(String calificacion, long idPedido) {
        this.calificacion = calificacion;
        this.idPedido = idPedido;
    }
}
