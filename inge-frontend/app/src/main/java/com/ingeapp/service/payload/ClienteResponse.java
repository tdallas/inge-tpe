package com.ingeapp.service.payload;

public class ClienteResponse {

    String email;
    String nombreYApellido;
    String DNI;
    boolean verificado;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public ClienteResponse(String email, String nombreYApellido, String DNI, boolean verificado) {

        this.email = email;
        this.nombreYApellido = nombreYApellido;
        this.DNI = DNI;
        this.verificado = verificado;
    }
}
