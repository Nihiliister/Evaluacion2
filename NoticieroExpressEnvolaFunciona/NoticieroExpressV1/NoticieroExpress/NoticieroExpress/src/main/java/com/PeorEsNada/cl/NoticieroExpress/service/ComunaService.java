package com.PeorEsNada.cl.NoticieroExpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PeorEsNada.cl.NoticieroExpress.model.Comuna;

import com.PeorEsNada.cl.NoticieroExpress.repository.ComunaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComunaService {
    @Autowired
    private ComunaRepository comunaRepository;

    public List<Comuna> findAll() {
        return comunaRepository.findAll();
    }

    public Comuna findById(Long id) {
        return comunaRepository.findById(id).get();
    }

    public Comuna save(Comuna comuna) {
        return comunaRepository.save(comuna);
    }

    public void delete(Long id){
        comunaRepository.deleteById(id);
    }

    public Comuna patchComuna(Long id, Comuna parcialComuna ) {
        Optional<Comuna> comunaOptional = comunaRepository.findById(id);
        if(comunaOptional.isPresent()) {
            Comuna comunaToUpdate = comunaOptional.get();

            if (parcialComuna.getNombreComuna() != null) {
                comunaToUpdate.setNombreComuna(parcialComuna.getNombreComuna());
            }
            return comunaRepository.save(comunaToUpdate);
        }else {
            throw new RuntimeException("Comuna no encontrada con ID: " + id);
        }
    }
}

