package com.dvmena.gadget_finder1.model;

import lombok.Builder;

@Builder
public class LoginResponse {
    private String response;

    private String name;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
