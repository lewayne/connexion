package com.exampleconnexion.connexion.services.auth.impl;

import com.exampleconnexion.connexion.security.jwt.JwtTokenProvider;
import com.exampleconnexion.connexion.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public Optional<Authentication> authenticateUser(String email, String password) {
        return Optional.ofNullable(authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        ));
    }

    @Override
    public String generateAccessToken(String email) {
        return jwtTokenProvider.generateJwtToken(email);
    }
}
