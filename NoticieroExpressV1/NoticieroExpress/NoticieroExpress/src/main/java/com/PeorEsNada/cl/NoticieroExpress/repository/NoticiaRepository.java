package com.PeorEsNada.cl.NoticieroExpress.repository;

import com.PeorEsNada.cl.NoticieroExpress.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long>{

    List<Noticia> findAll();
        @Query ("""
            SELECT a.nombreAutor, n.titulo 
            FROM Noticia n
            JOIN n.autor a
            ORDER BY a.nombreAutor
            """)
        List<Object[]> findNoticiasPorAutor();


    Noticia findByIdNoticia(Integer idNoticia);
    Noticia findByTitulo(String titulo);
    Noticia findByFechaPublicacion(Date fechaPublicacion);
    Noticia findByAutor_IdAutor(Integer autor_idAutor);



}
