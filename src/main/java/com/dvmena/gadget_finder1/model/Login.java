package com.dvmena.gadget_finder1.model;

import lombok.Builder;

public class Login {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
