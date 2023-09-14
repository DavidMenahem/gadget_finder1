package com.dvmena.gadget_finder1.controller;

import com.dvmena.gadget_finder1.exceptions.ApplicationException;
import com.dvmena.gadget_finder1.model.Login;
import com.dvmena.gadget_finder1.model.Response;
import com.dvmena.gadget_finder1.model.Register;
import com.dvmena.gadget_finder1.service.LoginService;
import com.dvmena.gadget_finder1.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.aot.generate.AccessControl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;
    private final LoginService loginService;

    @PostMapping("/login")
    public Response login(@RequestBody Login login){
        return loginService.login(login);
    }
    @PostMapping("/register")
    public Response register(@RequestBody Register register){

            return registerService.register(register);
    }
    @GetMapping("/all")
    public List<Register> getALl(){
        return registerService.getAll();
    }

    @DeleteMapping("/delete/{user}")
    public String deleteUser(@PathVariable String user){
        Register register = registerService.get(user);
        if(register != null) {
            return registerService.deleteUser(register.getId(),register.getEmail());
        }else{
            return "User not found";
        }
    }
}
