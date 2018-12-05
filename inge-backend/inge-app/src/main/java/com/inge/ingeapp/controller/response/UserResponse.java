package com.inge.ingeapp.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private boolean logged;

    public UserResponse(boolean b) {
        logged = b;
    }
}
