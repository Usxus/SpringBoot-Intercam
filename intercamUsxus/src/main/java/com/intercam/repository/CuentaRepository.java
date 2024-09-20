package com.intercam.repository;

import com.intercam.entities.CuentaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Luis.Bonifaz
 */
public interface CuentaRepository extends JpaRepository<CuentaEntity, Integer> {
    
    List<CuentaEntity> obtenerCuentaId(Integer id);

    List<CuentaEntity> obtenerCuenta();

    @Modifying
    void crearCuenta(@Param("numeroCuenta") Integer numeroCuenta,
            @Param("ingresos") Float ingresos);

    @Modifying
    int actualizarCuenta(@Param("id") Integer id,
            @Param("numeroCuenta") Integer numeroCuenta,
            @Param("ingresos") Float ingresos);

    @Modifying
    void eliminarCuenta(@Param("id") Integer id);
    
}
