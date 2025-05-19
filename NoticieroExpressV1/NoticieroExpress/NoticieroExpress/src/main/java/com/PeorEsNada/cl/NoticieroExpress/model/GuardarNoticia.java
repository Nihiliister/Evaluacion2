package com.PeorEsNada.cl.NoticieroExpress.model;

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
@Table (name = "Guardar noticia")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class GuardarNoticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGuardarNoticia;

    @ManyToOne
    @JoinColumn(name = "cuenta_idCuenta", nullable = false)
    private Cuenta cuenta;

    @ManyToOne
    @JoinColumn(name = "noticia_idNoticia",nullable = false)
    private Noticia noticia;
}
