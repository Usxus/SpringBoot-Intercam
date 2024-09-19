package com.intercam.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luis.Bonifaz
 */
@RestController
@RequestMapping("/api")
public class PruebaControlador {
    
    private static final Logger LOGGER = LogManager.getLogger();

    @GetMapping("/prueba")
    public String home() {
        LOGGER.info("prueba de log");
        return "Spring Boot";
    }

}
