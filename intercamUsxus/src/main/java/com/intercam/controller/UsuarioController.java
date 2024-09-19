package com.intercam.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.intercam.entities.UsuarioEntity;
import com.intercam.service.UsuarioService;
import static com.intercam.util.Constantes.MENSAJE;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<Map<String, String>> crearUsuario(@RequestBody UsuarioEntity usuario) {
        String msjCreacion = usuarioService.crearUsuario(usuario);
        Map<String, String> response = Collections.singletonMap(MENSAJE, msjCreacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Map<String, String>> actualizarUsuario(@PathVariable(name = "id", required = false) Integer id, @RequestBody UsuarioEntity usuarioRegistro) {
        String msjActualizado = usuarioService.actualizarUsuario(id, usuarioRegistro);
        Map<String, String> response = Collections.singletonMap(MENSAJE, msjActualizado);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, String>> eliminarUsuario(@PathVariable (name = "id", required = true) Integer id) {
        String msjeliminar = usuarioService.eliminarUsuario(id);
        Map<String, String> response = Collections.singletonMap(MENSAJE, msjeliminar);
        return ResponseEntity.ok(response);
    }
    
}
