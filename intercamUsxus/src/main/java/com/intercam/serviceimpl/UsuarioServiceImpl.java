package com.intercam.serviceimpl;

import com.intercam.entities.UsuarioEntity;
import com.intercam.exceptions.CustomExceptions;
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
                throw new CustomExceptions.ResourceNotFoundException("Usuario no encontrado con id: " + id);
            }
            return usuarios;
        } else {
            return usuarioRepository.obtenerUsuario();
        }
    }

    @Transactional
    @Override
    public String crearUsuario(UsuarioEntity usuario) {
        try {
            String nombre = usuario.getNombre();
            String apellidoPaterno = usuario.getApellidoPaterno();
            String apellidoMaterno = usuario.getApellidoMaterno();
            LocalDate fechaNacimiento = usuario.getFechaNacimiento();
            usuarioRepository.crearUsuario(nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
            return "Usuario creado con éxito";
        } catch (Exception ex) {
            LOGGER.error("Error al crear el usuario: " + ex.getMessage());
            throw new CustomExceptions.UnauthorizedException("Error al crear el usuario");
        }
    }

    @Transactional
    @Override
    public String actualizarUsuario(Integer id, UsuarioEntity usuario) {
        String nombre = usuario.getNombre();
        String apellidoPaterno = usuario.getApellidoPaterno();
        String apellidoMaterno = usuario.getApellidoMaterno();
        LocalDate fechaNacimiento = usuario.getFechaNacimiento();
        int filasAfectatas = usuarioRepository.actualizarUsuario(id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento);
        if (filasAfectatas == 0) {
            LOGGER.error("Error al actualizar el usuario: no se encontro el usuario");
            throw new CustomExceptions.UnauthorizedException("Error al actualizar el usuario: no se encontro el usuario: " + id);
        }
        return "Usuario actualizado con éxito";
    }

    @Transactional
    @Override
    public String eliminarUsuario(Integer id) {
        //Se desabilita la regla, por que es una consulta para hacer una validacion de que existe el usuario a eliminar
        List<UsuarioEntity> usuarios = usuarioRepository.obtenerUsuarioId(id); //NOSONAR
        if (usuarios != null && !usuarios.isEmpty()) {
            usuarioRepository.eliminarUsuario(id);
            return "Usuario eliminado con éxito";
        } else {
            throw new CustomExceptions.UnauthorizedException("Usuario no encontrado con id: " + id);
        }
    }

}
