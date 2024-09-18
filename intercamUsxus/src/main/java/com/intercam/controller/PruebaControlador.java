package com.intercam.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luis.Bonifaz
 */
@RestController
public class PruebaControlador {
    
    @GetMapping("/prueba")
    public String home() {
        return "Spring Boot";
    }
    
}
