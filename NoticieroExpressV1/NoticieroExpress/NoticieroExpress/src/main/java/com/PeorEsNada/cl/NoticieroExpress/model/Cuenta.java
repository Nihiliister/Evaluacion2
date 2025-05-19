package com.PeorEsNada.cl.NoticieroExpress.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Cuenta")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuenta;

    @Column(unique = true, nullable = false)
    private String correoCuenta;

    @Column(nullable = false)
    private String contraseñaCuenta;

    @Column(nullable = false)
    private String nombreCuenta;

    @ManyToOne
    @JoinColumn(name = "comuna_idComuna",nullable = false)
    private Comuna comuna;
}
