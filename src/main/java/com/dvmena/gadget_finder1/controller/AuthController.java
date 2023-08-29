package com.dvmena.gadget_finder1.controller;

import com.dvmena.gadget_finder1.model.Login;
import com.dvmena.gadget_finder1.model.Register;
import com.dvmena.gadget_finder1.service.LoginService;
import com.dvmena.gadget_finder1.service.RegisterService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;

    private final RegisterService registerService;

    @PostMapping("/user/login")
    @ResponseBody
    public String login(@RequestBody Login login){
        Optional<Register> register = registerService.get(login.getEmail());
        if(register.isPresent()){
            System.out.println(login.getPassword());
            if(register.get().getPassword().equals(login.getPassword())) {
                return loginService.login(login.getEmail(), login.getPassword());
            }
        }
        return "user not found";
    }
    @PostMapping("/user/register")
    public Register register(@RequestBody Register register){
        return registerService.register(register);
    }
}
