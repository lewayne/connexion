package com.exampleconnexion.connexion.services.auth;

import org.springframework.security.core.Authentication;

import java.util.Optional;

public interface AuthService {
    /**
     * Authenticate a user on the system
     * @param email
     * @param password
     * @return An Authentication object if the dealer is identified
     */
    Optional<Authentication> authenticateUser(String email, String password);

    /**
     * Generate an access token for a given email
     * @param email
     * @return
     */
    String generateAccessToken(String email);
}
