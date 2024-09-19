package com.intercam.serviceImpl;

import com.intercam.entities.UsuarioEntity;
import com.intercam.repository.UsuarioRepository;
import com.intercam.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luis.Bonifaz
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }
    
}
