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

import java.util.Date;

@Entity
@Table (name = "Noticia")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNoticia;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = true)
    private Date fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "autor_idAutor",nullable = false)
    private Autor autor;
}
