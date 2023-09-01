package com.dvmena.gadget_finder1.controller;

import com.dvmena.gadget_finder1.model.Login;
import com.dvmena.gadget_finder1.model.LoginResponse;
import com.dvmena.gadget_finder1.service.LoginService;
import com.dvmena.gadget_finder1.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class AuthController {

    private final LoginService loginService;

    @PostMapping
    public LoginResponse login(@RequestBody Login login){
        return loginService.login(login);
    }
}
