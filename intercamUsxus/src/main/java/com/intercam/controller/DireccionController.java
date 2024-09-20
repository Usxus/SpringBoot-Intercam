package com.intercam.controller;

import com.intercam.entities.DireccionEntity;
import com.intercam.service.DireccionService;
import static com.intercam.util.Constantes.MENSAJE;
import jakarta.validation.Valid;
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
@RequestMapping("/direccion")
public class DireccionController {
    
    @Autowired
    private DireccionService direccionService;

    @GetMapping("/consultar")
    public List<DireccionEntity> obtenerDireccion(@RequestParam(name = "id", required = false) Integer id) {
        return direccionService.obtenerDireccion(id);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Map<String, String>> crearDireccion(@RequestBody DireccionEntity direccion) {
        String msjCreacion = direccionService.crearDireccion(direccion);
        Map<String, String> response = Collections.singletonMap(MENSAJE, msjCreacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Map<String, String>> actualizarDireccion(@PathVariable(name = "id", required = false) Integer id, @Valid @RequestBody DireccionEntity direccionRegistro) {
        String msjActualizado = direccionService.actualizarDireccion(id, direccionRegistro);
        Map<String, String> response = Collections.singletonMap(MENSAJE, msjActualizado);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, String>> eliminarDireccion(@PathVariable (name = "id", required = true) Integer id) {
        String msjeliminar = direccionService.eliminarDireccion(id);
        Map<String, String> response = Collections.singletonMap(MENSAJE, msjeliminar);
        return ResponseEntity.ok(response);
    }
    
}
