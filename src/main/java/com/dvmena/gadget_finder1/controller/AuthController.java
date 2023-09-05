package com.dvmena.gadget_finder1.controller;

import com.dvmena.gadget_finder1.model.Login;
import com.dvmena.gadget_finder1.model.Response;
import com.dvmena.gadget_finder1.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class AuthController {

    private final LoginService loginService;

    @PostMapping
    public Response login(@RequestBody Login login){
        return loginService.login(login);
    }
}
