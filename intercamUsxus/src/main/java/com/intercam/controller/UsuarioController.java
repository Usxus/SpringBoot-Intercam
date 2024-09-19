package com.intercam.controller;

import com.intercam.entities.UsuarioEntity;
import com.intercam.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<UsuarioEntity> obtenerUsuario(@RequestParam(name = "id", required = false) Integer id) {
        return usuarioService.obtenerUsuario(id);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioEntity usuario) {
        String msjCreacion = usuarioService.crearUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(msjCreacion);
    }
//
//    @PutMapping("/actualizar/{id}")
//    public ResponseEntity<String> actualizarUsuario(@RequestParam(name = "id", required = true) Integer id, @RequestBody UsuarioEntity usuarioRegistro) {
//        String msjActualizado = usuarioService.actualizarUsuario(id, usuarioRegistro);
//        return ResponseEntity.ok(msjActualizado);
//    }
//
//    @DeleteMapping("/eliminar/{id}")
//    public ResponseEntity<Void> eliminarUsuario(@RequestParam (name = "id", required = true) Integer id) {
//        usuarioService.eliminarUsuario(id);
//        return ResponseEntity.noContent().build();
//    }
    
}
