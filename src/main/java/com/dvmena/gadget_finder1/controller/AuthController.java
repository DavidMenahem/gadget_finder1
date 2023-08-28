package com.dvmena.gadget_finder1.controller;

import com.dvmena.gadget_finder1.model.Login;
import com.dvmena.gadget_finder1.model.Register;
import com.dvmena.gadget_finder1.service.LoginService;
import com.dvmena.gadget_finder1.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("login")
public class AuthController {

    private final LoginService loginService;

    private final RegisterService registerService;

    @PostMapping
    public String login(@RequestBody Login login) throws IOException {;
        Optional<Register> register = registerService.get(login.getEmail());

        if(register.isPresent()){
            System.out.println(login.getPassword());
            if(register.get().getPassword().equals(login.getPassword())) {
                return loginService.login(login.getEmail(), login.getPassword());
            }
        }
        return "user not found";
    }
}
