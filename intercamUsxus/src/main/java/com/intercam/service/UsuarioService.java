package com.intercam.service;

import com.intercam.entities.UsuarioEntity;
import java.util.List;

/**
 *
 * @author Luis.Bonifaz
 */
public interface UsuarioService {
    
    List<UsuarioEntity> obtenerUsuario(Integer id);
        
    String crearUsuario(UsuarioEntity usuario);
    
//    String actualizarUsuario(Integer id, UsuarioEntity usuarioRegistro);
//    
//    List<UsuarioEntity> eliminarUsuario(Integer id);
            
}
