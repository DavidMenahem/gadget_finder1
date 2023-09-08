package com.dvmena.gadget_finder1.service;

import com.dvmena.gadget_finder1.model.Response;

public class ResponseService {
    private Response loginResponse;

    protected Response loginResponse(Long userID, String email, String response){
        return Response.builder()
                .userID(userID)
                .email(email)
                .response(response)
                .build();
    }

    protected Response loginResponseFailed(String response){
        return Response.builder().response(response).build();
    }
}
