package com.dvmena.gadget_finder1.service;

import com.dvmena.gadget_finder1.exceptions.ApplicationException;
import com.dvmena.gadget_finder1.model.Response;
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

    public Response register(Register register){
        String response;

            Optional<Register> registerFromDatabase = registerRepository.findByEmail(register.getEmail());

        if(registerFromDatabase.isPresent()){
            response = "User already exists";
            return super.loginResponseFailed(response);
        }else{
            Register register1 = registerRepository.save(register);
            response = "User created";
            return  super.loginResponse(register1.getId(),
                    register1.getEmail(),
                    register1.getUserFirstName(),
                    register1.getUserLastName(),
                    response);
        }
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
