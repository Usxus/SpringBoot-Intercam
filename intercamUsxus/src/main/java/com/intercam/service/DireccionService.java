package com.intercam.service;

import com.intercam.entities.DireccionEntity;
import java.util.List;

/**
 *
 * @author Luis.Bonifaz
 */
public interface DireccionService {
    
    List<DireccionEntity> obtenerDireccion(Integer id);
        
    String crearDireccion(DireccionEntity direccion);
    
    String actualizarDireccion(Integer id, DireccionEntity direccionRegistro);
    
    String eliminarDireccion(Integer id);
    
}
