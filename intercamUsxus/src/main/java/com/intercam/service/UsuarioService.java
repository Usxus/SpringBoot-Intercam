package com.intercam.service;

import com.intercam.entities.UsuarioEntity;
import java.util.List;

/**
 *
 * @author Luis.Bonifaz
 */
public interface UsuarioService {
    
    List<UsuarioEntity> obtenerTodosLosUsuarios();
            
}
