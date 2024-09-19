package com.intercam.serviceImpl;

import com.intercam.entities.UsuarioEntity;
import com.intercam.exceptions.ResourceNotFoundException;
import com.intercam.repository.UsuarioRepository;
import com.intercam.service.UsuarioService;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Luis.Bonifaz
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> obtenerUsuario(Integer id) {
        if (id != null) {
            List<UsuarioEntity> usuarios = usuarioRepository.obtenerUsuarioId(id);
            if (usuarios.isEmpty()) {
                throw new ResourceNotFoundException("Usuario no encontrado con id: " + id);
            }
            return usuarios;
        } else {
            return usuarioRepository.obtenerUsuario();
        }
    }

    @Transactional
    public String crearUsuario(UsuarioEntity usuario) {
        try {
            String nombre = usuario.getNombre();
            String apellidoPaterno = usuario.getApellidoPaterno();
            String apellidoMaterno = usuario.getApellidoMaterno();
            LocalDate fechaNacimiento = usuario.getFechaNacimiento();
            usuarioRepository.crearUsuario(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
            return "Usuario creado con éxito";
        } catch (Exception e) {
            // Registrar el error en el log (opcional)
            LOGGER.error("Error al crear el usuario: " + e.getMessage());
            return "Error al crear el usuario";
        }
    }
    
}
