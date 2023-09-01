package com.dvmena.gadget_finder1.controller;

import com.dvmena.gadget_finder1.model.LoginResponse;
import com.dvmena.gadget_finder1.model.Register;
import com.dvmena.gadget_finder1.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping("/register")
    public LoginResponse register(@RequestBody Register register){
        return registerService.register(register);
    }
    @GetMapping("/all")
    public List<Register> getALl(){
        return registerService.getAll();
    }
}
