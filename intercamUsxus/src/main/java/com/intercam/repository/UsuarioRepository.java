package com.intercam.repository;

import com.intercam.entities.UsuarioEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Luis.Bonifaz
 */
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    
    List<UsuarioEntity> findAll();

}
