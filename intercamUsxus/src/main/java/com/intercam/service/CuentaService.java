package com.intercam.service;

import com.intercam.entities.CuentaEntity;
import java.util.List;

/**
 *
 * @author Luis.Bonifaz
 */
public interface CuentaService {
    
    List<CuentaEntity> obtenerCuenta(Integer id);
        
    String crearCuenta(CuentaEntity cuenta);
    
    String actualizarCuenta(Integer id, CuentaEntity cuentaRegistro);
    
    String eliminarCuenta(Integer id);
    
}
