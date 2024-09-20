package com.intercam.serviceimpl;

import com.intercam.entities.DireccionEntity;
import com.intercam.exceptions.CustomExceptions;
import com.intercam.repository.DireccionRepository;
import com.intercam.service.DireccionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Luis.Bonifaz
 */
@Service
public class DireccionServiceImpl implements DireccionService {

    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    public List<DireccionEntity> obtenerDireccion(Integer id) {
        if (id != null) {
            List<DireccionEntity> direccion = direccionRepository.obtenerDireccionId(id);
            if (direccion.isEmpty()) {
                throw new CustomExceptions.ResourceNotFoundException("Direccion no encontrado con el siguiente id: " + id);
            }
            return direccion;
        } else {
            return direccionRepository.obtenerDireccion();
        }
    }

    @Transactional
    @Override
    public String crearDireccion(DireccionEntity direccion) {
        try {
            String codigoPostal = direccion.getCodigoPostal();
            if (codigoPostal.length() != 6){
                throw new IllegalArgumentException("El código postal debe tener 6 caracteres");
            }
            String estado = direccion.getEstado();
            direccionRepository.crearDireccion(codigoPostal, estado);
            return "Direccion creado con éxito";
        } catch (Exception ex) {
            throw new CustomExceptions.UnauthorizedException("Error al crear la direccion: " + ex.getMessage());
        }
    }

    @Transactional
    @Override
    public String actualizarDireccion(Integer id, DireccionEntity direccionRegistro) {
        String codigoPostal = direccionRegistro.getCodigoPostal();
        String estado = direccionRegistro.getEstado();
        int filasAfectatas = direccionRepository.actualizarDireccion(id, codigoPostal, estado);
        if (filasAfectatas == 0) {
            throw new CustomExceptions.UnauthorizedException("Error al actualizar el direccion: no se encontro el registro con el siguiente id: " + id);
        }
        return "Direccion actualizado con éxito";
    }

    @Transactional
    @Override
    public String eliminarDireccion(Integer id) {
        List<DireccionEntity> direccion = direccionRepository.obtenerDireccionId(id); //NOSONAR
        if (direccion != null && !direccion.isEmpty()) {
            direccionRepository.eliminarDireccion(id);
            return "Direccion eliminada con éxito";
        } else {
            throw new CustomExceptions.UnauthorizedException("Direccion no encontrado con el siguiente id: " + id);
        }
    }

}
