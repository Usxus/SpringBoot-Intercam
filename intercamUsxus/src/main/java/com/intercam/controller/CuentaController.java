package com.intercam.controller;

import com.intercam.entities.CuentaEntity;
import com.intercam.service.CuentaService;
import static com.intercam.util.Constantes.MENSAJE;
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
@RequestMapping("/cuenta")
public class CuentaController {
    
    @Autowired
    private CuentaService usuarioService;

    @GetMapping("/consultar")
    public List<CuentaEntity> obtenerCuenta(@RequestParam(name = "id", required = false) Integer id) {
        return usuarioService.obtenerCuenta(id);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<Map<String, String>> crearCuenta(@RequestBody CuentaEntity cuenta) {
        String msjCreacion = usuarioService.crearCuenta(cuenta);
        Map<String, String> response = Collections.singletonMap(MENSAJE, msjCreacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Map<String, String>> actualizarCuenta(@PathVariable(name = "id", required = false) Integer id, @RequestBody CuentaEntity cuentaRegistro) {
        String msjActualizado = usuarioService.actualizarCuenta(id, cuentaRegistro);
        Map<String, String> response = Collections.singletonMap(MENSAJE, msjActualizado);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, String>> eliminarCuenta(@PathVariable (name = "id", required = true) Integer id) {
        String msjeliminar = usuarioService.eliminarCuenta(id);
        Map<String, String> response = Collections.singletonMap(MENSAJE, msjeliminar);
        return ResponseEntity.ok(response);
    }
    
}
