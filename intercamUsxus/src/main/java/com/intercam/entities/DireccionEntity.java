package com.intercam.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author Luis.Bonifaz
 */
@Entity
@Data
public class DireccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 6, max = 6, message = "El código postal debe tener 6 caracteres")
    @Column(nullable = false)
    private String codigoPostal;

    @Column(nullable = false)
    private String estado;
    
}
