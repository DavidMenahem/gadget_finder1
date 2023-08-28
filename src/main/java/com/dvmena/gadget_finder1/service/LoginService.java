package com.dvmena.gadget_finder1.service;

import com.dvmena.gadget_finder1.security.CustomAuthenticationManager;
import com.dvmena.gadget_finder1.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final TokenService tokenService;
    private final CustomAuthenticationManager authenticationManager;

    public String login(String email,String password) throws RuntimeException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email,password)
            );
        } catch (final BadCredentialsException e) {
            throw new RuntimeException("Incorrect credentials");
        }
        return tokenService.generateToken(email);
    }
}
