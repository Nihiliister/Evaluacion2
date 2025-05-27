package com.PeorEsNada.cl.NoticieroExpress.repository;

import com.PeorEsNada.cl.NoticieroExpress.model.GuardarNoticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GuardarNoticiaRepository extends JpaRepository<GuardarNoticia, Long>{

    List<GuardarNoticia> findAll(); 

         @Query("""
            SELECT c.nombreCuenta, n.titulo
            FROM GuardarNoticia g
            JOIN g.cuenta c
            JOIN g.noticia n
            ORDER BY c.nombreCuenta
            """)
        List<Object[]> findNoticiasCuenta();


    GuardarNoticia findByIdGuardarNoticia(Integer idGuardarNoticia);
    GuardarNoticia findByCuenta_IdCuenta(Integer cuenta_idCuenta);
    GuardarNoticia findByNoticia_IdNoticia(Integer noticia_idNoticia);
    
}
