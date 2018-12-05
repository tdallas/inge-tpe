package com.ingeapp.service.payload;

public class UserResponse {
    private boolean logged = false;
    private String rol = "";
    public UserResponse(boolean logged, String rol) {
        this.logged = logged;
        this.rol = rol;
    }

    public boolean getLogged() {
        return logged;
    }
    public String getRol() { return rol; }
}
