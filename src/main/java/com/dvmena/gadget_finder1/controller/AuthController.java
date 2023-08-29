package com.dvmena.gadget_finder1.controller;

import com.dvmena.gadget_finder1.model.Login;
import com.dvmena.gadget_finder1.model.LoginResponse;
import com.dvmena.gadget_finder1.model.Register;
import com.dvmena.gadget_finder1.service.LoginService;
import com.dvmena.gadget_finder1.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class AuthController {

    private final LoginService loginService;

    private final RegisterService registerService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody Login login){
                return new LoginResponse(loginService.login(login));
    }
    @PostMapping("/register")
    public Register register(@RequestBody Register register){
        return registerService.register(register);
    }
}
