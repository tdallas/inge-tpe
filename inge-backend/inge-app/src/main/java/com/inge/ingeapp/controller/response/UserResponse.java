package com.inge.ingeapp.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private boolean logged;
    private String rol;

    public UserResponse(boolean logged, String rol) {
        this.logged = logged;
        this.rol = rol;
    }
}
