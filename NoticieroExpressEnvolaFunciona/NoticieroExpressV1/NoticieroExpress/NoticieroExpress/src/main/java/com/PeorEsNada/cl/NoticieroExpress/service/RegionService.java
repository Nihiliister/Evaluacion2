package com.PeorEsNada.cl.NoticieroExpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.PeorEsNada.cl.NoticieroExpress.model.Region;
import com.PeorEsNada.cl.NoticieroExpress.repository.RegionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    public Region findById(Long id) {
        return regionRepository.findById(id).get();
    }

    public Region save(Region region) {
        return regionRepository.save(region);
    }

    public void delete(Long id){
        regionRepository.deleteById(id);
    }

    public Region patchRegion(Long id, Region parcialRegion ) {
        Optional<Region> regionOptional = regionRepository.findById(id);
        if(regionOptional.isPresent()) {
            Region regionToUpdate = regionOptional.get();

            if (parcialRegion.getNombreRegion() != null) {
                regionToUpdate.setNombreRegion(parcialRegion.getNombreRegion());
            }
            return regionRepository.save(regionToUpdate);
        }else {
            throw new RuntimeException("Region no encontrada con ID: " + id);
        }
    }
}
