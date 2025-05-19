package com.PeorEsNada.cl.NoticieroExpress.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "Autor")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAutor;

    @Column(nullable = false)
    private String nombreAutor;

    @Column(nullable = false)
    private String correoAutor;

    @Column(nullable = false)
    private String contraseñaAutor;
}
