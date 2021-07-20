package com.exampleconnexion.connexion.controller;

import com.exampleconnexion.connexion.payload.JwtResponse;
import com.exampleconnexion.connexion.payload.LoginRequest;
import com.exampleconnexion.connexion.security.CustomUserDetails;
import com.exampleconnexion.connexion.services.auth.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Api(value = "Endpoint for authentification purposes")
public class AuthController {
    private static final Logger logger = LogManager.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    /**
     * Endpoint to authenticate a dealer on the application
     * @param loginRequest
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "Authenticate a dealer on the system")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody LoginRequest loginRequest){ //@Valid
        logger.debug("Authenticating dealer with username {}", loginRequest.getUsername());

        Optional<Authentication> authenticationOpt = authService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = authenticationOpt.orElseThrow(() -> new RuntimeException("Couldn't authenticate dealer [" + loginRequest + "]"));

        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = authService.generateAccessToken(customUserDetails.getUsername());

        return new ResponseEntity<>(new JwtResponse(accessToken, customUserDetails.getAuthorities()), HttpStatus.OK);
    }
}
