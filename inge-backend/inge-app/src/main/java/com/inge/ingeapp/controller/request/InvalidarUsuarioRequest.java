package com.inge.ingeapp.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InvalidarUsuarioRequest {
    private String email;
    private boolean invalidar;
}
