package com.dvmena.gadget_finder1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GadgetFinderExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(ApplicationException.class)
    public String handleCouponCustomException(ApplicationException e){
        return e.getMessage();
    }
}