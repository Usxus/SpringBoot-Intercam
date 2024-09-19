package com.intercam.controller;

import com.intercam.entities.UsuarioEntity;
import com.intercam.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luis.Bonifaz
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/consultar")
    public List<UsuarioEntity> obtenerUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }
    
}
