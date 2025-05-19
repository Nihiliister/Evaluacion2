package com.PeorEsNada.cl.NoticieroExpress.repository;

import com.PeorEsNada.cl.NoticieroExpress.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long>{

    List<Region> findAll();

    Region findByIdRegion(Integer idRegion);
    Region findByNombreRegion(String nombreRegion);
}
