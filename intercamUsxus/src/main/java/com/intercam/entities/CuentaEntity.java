package com.intercam.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;

/**
 *
 * @author Luis.Bonifaz
 */
@Entity
@Data
public class CuentaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer numeroCuenta;

    @DecimalMin(value = "0.01", message = "Los ingresos deben ser mayores a 0")
    @Column(nullable = false)
    private Float ingresos;
    
}
