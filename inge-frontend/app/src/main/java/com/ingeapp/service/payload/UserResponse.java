package com.ingeapp.service.payload;

public class UserResponse {
    private boolean logged = false;

    public UserResponse(boolean logged) {
        this.logged = logged;
    }

    public boolean getLogget() {
        return logged;
    }
}
