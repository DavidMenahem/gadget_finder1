package com.dvmena.gadget_finder1.service;

import com.dvmena.gadget_finder1.model.Response;

public class ResponseService {
    private Response loginResponse;

    protected Response loginResponse(Long userID, String email, String firstname, String lastname, String response){
        return Response.builder()
                .userID(userID)
                .email(email)
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

    protected Response loginResponseFailed(String response){
        return Response.builder().response(response).build();
    }
}
