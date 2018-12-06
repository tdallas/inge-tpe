package com.inge.ingeapp.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private boolean logged;
    private String rol;
    private Long id;
    private String direccion;

    public UserResponse(boolean logged, String rol, Long id, String direccion) {
        this.logged = logged;
        this.rol = rol;
        this.id = id;
        this.direccion = direccion;
    }
}
