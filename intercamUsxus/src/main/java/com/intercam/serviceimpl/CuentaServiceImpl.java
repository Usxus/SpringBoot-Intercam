package com.intercam.serviceimpl;

import com.intercam.entities.CuentaEntity;
import com.intercam.exceptions.CustomExceptions;
import com.intercam.repository.CuentaRepository;
import com.intercam.service.CuentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Luis.Bonifaz
 */
@Service
public class CuentaServiceImpl implements CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public List<CuentaEntity> obtenerCuenta(Integer id) {
        if (id != null) {
            List<CuentaEntity> usuarios = cuentaRepository.obtenerCuentaId(id);
            if (usuarios.isEmpty()) {
                throw new CustomExceptions.ResourceNotFoundException("Cuenta no encontrado con el siguiente id: : " + id);
            }
            return usuarios;
        } else {
            return cuentaRepository.obtenerCuenta();
        }
    }

    @Transactional
    @Override
    public String crearCuenta(CuentaEntity cuenta) {
        try {
            Integer numeroCuenta = cuenta.getNumeroCuenta();
            String validacionDigitos = Integer.toString(numeroCuenta);
            if (validacionDigitos.length() != 10) {
                throw new IllegalArgumentException("El código postal debe tener 10 digitos");
            }
            Float ingresos = cuenta.getIngresos();
            if (ingresos == null || ingresos <= 0) {
                throw new IllegalArgumentException("Los ingresos deben ser mayores a 0");
            }
            cuentaRepository.crearCuenta(numeroCuenta, ingresos);
            return "Cuenta creado con éxito";
        } catch (Exception ex) {
            throw new CustomExceptions.UnauthorizedException("Error al crear el cuenta: " + ex.getMessage());
        }
    }

    @Transactional
    @Override
    public String actualizarCuenta(Integer id, CuentaEntity cuenta) {
        Integer numeroCuenta = cuenta.getNumeroCuenta();
        Float ingresos = cuenta.getIngresos();
        int filasAfectatas = cuentaRepository.actualizarCuenta(id, numeroCuenta, ingresos);
        if (filasAfectatas == 0) {
            throw new CustomExceptions.UnauthorizedException("Error al actualizar la cuenta: no se encontro el registro con el siguiente id: " + id);
        }
        return "Cuenta actualizada con éxito";
    }

    @Transactional
    @Override
    public String eliminarCuenta(Integer id) {
        List<CuentaEntity> cuenta = cuentaRepository.obtenerCuentaId(id); //NOSONAR
        if (cuenta != null && !cuenta.isEmpty()) {
            cuentaRepository.eliminarCuenta(id);
            return "Cuenta eliminado con éxito";
        } else {
            throw new CustomExceptions.UnauthorizedException("Cuenta no encontrado con el siguiente id: " + id);
        }
    }

}
