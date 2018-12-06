package com.ingeapp.model.request;

public class SignUpRequest {

    public String getDireccion() {
        return direccion;
    }

    private String direccion;
    private String email;
    private String clave;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;

    public SignUpRequest(String email, String clave, String dni, String telefono, String nombre, String apellido,
                         String direccion) {
        this.email = email;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
