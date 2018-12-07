package com.ingeapp.service.payload;

public class UpdateRequest {

    private String mailActual;
    private String claveActual;
    private String mail;
    private String clave;
    private String telefono;
    private Long idUser;
    private String direcction;

    public UpdateRequest(String mailActual, String claveActual, String mail, String clave, String telefono, String direccion, Long idUser) {
        this.mail = mail;
        this.clave = clave;
        this.telefono = telefono;
        this.direcction = direccion;
        this.idUser = idUser;
        this.mailActual = mailActual;
        this.claveActual = claveActual;
    }

    public String getMailActual() {
        return mailActual;
    }

    public String getClaveActual() {
        return claveActual;
    }

    public String getMail() {
        return mail;
    }

    public String getClave() {
        return clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getDirecction() {
        return direcction;
    }
}
