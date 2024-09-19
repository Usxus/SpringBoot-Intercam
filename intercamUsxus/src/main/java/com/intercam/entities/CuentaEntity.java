package com.intercam.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
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
    private int id;

    @Digits(integer = 10, fraction = 0)
    @Column(nullable = false)
    private long numeroCuenta;

    @Min(value = 1, message = "Los ingresos deben ser mayores a 0")
    @Column(nullable = false)
    private float ingresos;
    
}
