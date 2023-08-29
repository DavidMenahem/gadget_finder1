package com.dvmena.gadget_finder1.service;

import com.dvmena.gadget_finder1.model.Login;
import com.dvmena.gadget_finder1.model.Register;
//import com.dvmena.gadget_finder1.security.CustomAuthenticationManager;
//import com.dvmena.gadget_finder1.security.TokenService;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

//    private final TokenService tokenService;
//    private final CustomAuthenticationManager authenticationManager;
    private final RegisterService registerService;
    public String login(Login login){
       Register register = registerService.get(login.getEmail());

            if(register.getPassword().equals(login.getPassword())){
                return "User is logged in";
            }
        return "Wrong credentials";
    }

//    public String login(String email,String password) throws RuntimeException {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(email,password)
//            );
//        } catch (final BadCredentialsException e) {
//            throw new RuntimeException("Incorrect credentials");
//        }
//        return tokenService.generateToken(email);
//    }
}
