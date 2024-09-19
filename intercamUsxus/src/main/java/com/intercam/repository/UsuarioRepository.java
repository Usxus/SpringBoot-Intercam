package com.intercam.repository;

import com.intercam.entities.UsuarioEntity;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Luis.Bonifaz
 */
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    
    List<UsuarioEntity> obtenerUsuarioId(Integer id);
    
    List<UsuarioEntity> obtenerUsuario();
    
    @Modifying
    void crearUsuario(@Param ("nombre") String nombre,
            @Param ("apellidoPaterno") String apellidoPaterno,
            @Param ("apellidoMaterno") String apellidoMaterno,
            @Param ("fechaNacimiento") LocalDate fechaNacimiento);
    
//    @Transactional
//    void crearUsuario(String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento);
    
//    
//    @Transactional
//    void crearUsuario(UsuarioEntity id);

}
