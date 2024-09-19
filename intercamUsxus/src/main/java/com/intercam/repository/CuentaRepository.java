package com.intercam.repository;

import com.intercam.entities.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Luis.Bonifaz
 */
public interface CuentaRepository extends JpaRepository<CuentaEntity, Integer> {
    
}
