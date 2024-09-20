package com.intercam.controller;

import com.intercam.dto.DatosClientesDTO;
import com.intercam.service.DatosClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luis.Bonifaz
 */
@RestController
@RequestMapping("/datosClientes")
public class ComplementarioDatosClientesController {
    
    @Autowired
    private DatosClientesService datosClientes;

    @GetMapping("/consultar")
    public DatosClientesDTO obtenerCuenta(@RequestParam(name = "id", required = true) Integer id) {
        return datosClientes.obtenerDatosClientes(id);
    }
    
}
