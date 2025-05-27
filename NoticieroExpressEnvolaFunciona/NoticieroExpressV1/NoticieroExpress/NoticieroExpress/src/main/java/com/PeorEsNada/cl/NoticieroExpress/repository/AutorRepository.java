package com.PeorEsNada.cl.NoticieroExpress.repository;

import com.PeorEsNada.cl.NoticieroExpress.model.Autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

    List<Autor> findAll();

   

    List<Autor> findByIdAutor(Integer idAutor);
    List<Autor> findByNombreAutor(String nombreAutor);
    List<Autor> findByCorreoAutor(String correoAutor);
    List<Autor> findByContraseñaAutor(String contraseñaAutor);
}
