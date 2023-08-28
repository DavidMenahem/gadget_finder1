package com.dvmena.gadget_finder1.controller;

import com.dvmena.gadget_finder1.model.Register;
import com.dvmena.gadget_finder1.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping
    public Register register(@RequestBody Register register){
        return registerService.register(register);
    }
}
