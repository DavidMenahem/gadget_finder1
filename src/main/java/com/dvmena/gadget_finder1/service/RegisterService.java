package com.dvmena.gadget_finder1.service;

import com.dvmena.gadget_finder1.model.Register;
import com.dvmena.gadget_finder1.repository.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterService {

    private final RegisterRepository registerRepository;

    public Register register(Register register){
        return registerRepository.save(register);
    }

    public Register get(String email){
        Register register = registerRepository.findByEmail(email);
        return register;
    }
}
