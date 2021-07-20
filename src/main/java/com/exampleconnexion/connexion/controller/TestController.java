package com.exampleconnexion.connexion.controller;

import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/azerty")
@Api(value = "autre")
public class TestController {
    private static final Logger logger = LogManager.getLogger(TestController.class);

    @GetMapping("/index")
    public String index(){
        logger.error("essai .....");
        return "Je suis en mode non Sécuriser";
    }
}
