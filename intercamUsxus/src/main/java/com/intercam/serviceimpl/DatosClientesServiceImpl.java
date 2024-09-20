package com.intercam.serviceimpl;

import com.intercam.entities.CuentaEntity;
import com.intercam.dto.DatosClientesDTO;
import com.intercam.entities.DireccionEntity;
import com.intercam.entities.UsuarioEntity;
import com.intercam.exceptions.CustomExceptions;
import com.intercam.repository.CuentaRepository;
import com.intercam.repository.DireccionRepository;
import com.intercam.repository.UsuarioRepository;
import com.intercam.service.DatosClientesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luis.Bonifaz
 */
@Service
public class DatosClientesServiceImpl implements DatosClientesService {

    private static final String CORCHETES_REGEX = "\\[|\\]";

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DireccionRepository direccionRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public DatosClientesDTO obtenerDatosClientes(Integer id) {
        try {
            List<UsuarioEntity> usuarios = usuarioRepository.obtenerUsuarioId(id);
            List<DireccionEntity> direccion = direccionRepository.obtenerDireccionId(id);
            List<CuentaEntity> cuenta = cuentaRepository.obtenerCuentaId(id);
            String usuariosStr = usuarios.toString().replaceAll(CORCHETES_REGEX, "");
            String direccionStr = direccion.toString().replaceAll(CORCHETES_REGEX, "");
            String cuentaStr = cuenta.toString().replaceAll(CORCHETES_REGEX, "");
            return new DatosClientesDTO(usuariosStr, direccionStr, cuentaStr);
        } catch (Exception ex) {
            throw new CustomExceptions.UnauthorizedException("Ha ocurrido un error: " + ex.getMessage());
        }
    }

}
