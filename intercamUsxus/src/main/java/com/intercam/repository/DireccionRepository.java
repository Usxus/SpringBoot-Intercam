package com.intercam.repository;

import com.intercam.entities.DireccionEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Luis.Bonifaz
 */
public interface DireccionRepository extends JpaRepository<DireccionEntity, Integer> {

    List<DireccionEntity> obtenerDireccionId(Integer id);

    List<DireccionEntity> obtenerDireccion();

    @Modifying
    void crearDireccion(@Param("codigoPostal") String codigoPostal,
            @Param("estado") String estado);

    @Modifying
    int actualizarDireccion(@Param("id") Integer id,
            @Param("codigoPostal") String codigoPostal,
            @Param("estado") String estado);

    @Modifying
    void eliminarDireccion(@Param("id") Integer id);

}
