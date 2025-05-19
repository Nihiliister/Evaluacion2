package com.PeorEsNada.cl.NoticieroExpress.repository;


import com.PeorEsNada.cl.NoticieroExpress.model.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ComunaRepository extends JpaRepository<Comuna, Long>{

   List<Comuna> findAll();

    Comuna findByIdComuna (Integer idComuna);
    Comuna findByNombreComuna (String nombreComuna);
    Comuna findByRegion_IdRegion (Integer region_idRegion);


}
