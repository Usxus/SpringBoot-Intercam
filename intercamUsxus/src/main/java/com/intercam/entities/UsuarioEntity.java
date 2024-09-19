package com.intercam.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Past;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author Luis.Bonifaz
 */
@Entity
@Data
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidoPaterno;

    @Column(nullable = false)
    private String apellidoMaterno;

    @Past
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

}
