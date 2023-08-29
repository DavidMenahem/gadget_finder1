package com.dvmena.gadget_finder1.controller;

import com.dvmena.gadget_finder1.model.Login;
import com.dvmena.gadget_finder1.model.Register;
import com.dvmena.gadget_finder1.service.LoginService;
import com.dvmena.gadget_finder1.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class AuthController {

    private final LoginService loginService;

    private final RegisterService registerService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login){
        // Create a HttpHeaders object.
        HttpHeaders headers = new HttpHeaders();

        // Set the content type header to application/json.
        headers.setContentType(MediaType.APPLICATION_JSON);
        Optional<Register> register = registerService.get(login.getEmail());
        if(register.isPresent()){
            System.out.println(login.getPassword());
            if(register.get().getPassword().equals(login.getPassword())) {

                String token =  loginService.login(login.getEmail(), login.getPassword());
                ResponseEntity<String> response = new ResponseEntity<>(token,headers, HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("user not found",headers,HttpStatus.OK);
    }
    @PostMapping("/register")
    public Register register(@RequestBody Register register){
        return registerService.register(register);
    }
}
