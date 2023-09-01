package com.dvmena.gadget_finder1.service;

import com.dvmena.gadget_finder1.model.LoginResponse;
import lombok.extern.java.Log;

public class ResponseService {
    private LoginResponse loginResponse;

    protected LoginResponse loginResponse(String firstname,String lastname,String response){
        return LoginResponse.builder()
                .name(nameBuilder(firstname,lastname))
                .response(response)
                .build();
    }

    protected  String nameBuilder(String firstName,String lastname){
        return new StringBuilder(
                        firstName
                        + " "
                        + lastname)
                .toString();
    }
}
