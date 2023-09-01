package com.dvmena.gadget_finder1.service;

import com.dvmena.gadget_finder1.model.LoginResponse;
import com.dvmena.gadget_finder1.model.Register;
import com.dvmena.gadget_finder1.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterService extends ResponseService{

    private final RegisterRepository registerRepository;

    public LoginResponse register(Register register){
        String response;
        Optional<Register> registerFromDatabase = registerRepository.findByEmail(register.getEmail());
        if(registerFromDatabase.isPresent()){
            response = "User already exists";

        }else{
            registerRepository.save(register);
            response = "User created";
        }
        return  super.loginResponse(register.getUser_first_name(),
                register.getUser_last_name(),
                response);
    }

    public Register get(String email){
        Optional<Register> register = registerRepository.findByEmail(email);
        if(register.isPresent()) {
            return register.get();
        }else{
            return null;
        }
    }

    public List<Register> getAll(){
        return registerRepository.findAll();
    }
}
