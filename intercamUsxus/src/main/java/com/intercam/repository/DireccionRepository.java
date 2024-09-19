package com.intercam.repository;

import com.intercam.entities.DireccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Luis.Bonifaz
 */
public interface DireccionRepository extends JpaRepository<DireccionEntity, Integer> {
    
}
