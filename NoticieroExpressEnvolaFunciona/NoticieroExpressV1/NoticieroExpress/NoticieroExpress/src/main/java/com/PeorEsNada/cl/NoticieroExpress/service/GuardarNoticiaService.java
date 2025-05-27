package com.PeorEsNada.cl.NoticieroExpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PeorEsNada.cl.NoticieroExpress.model.GuardarNoticia;
import com.PeorEsNada.cl.NoticieroExpress.repository.GuardarNoticiaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class GuardarNoticiaService {
@Autowired
    private GuardarNoticiaRepository guardarNoticiaRepository;

    public List<GuardarNoticia> findAll() {
        return guardarNoticiaRepository.findAll();
    }

    public GuardarNoticia findById(Long id) {
        return guardarNoticiaRepository.findById(id).get();
    }

    public GuardarNoticia save(GuardarNoticia guardarNoticia) {
        return guardarNoticiaRepository.save(guardarNoticia);
    }

    public void delete(Long id){
        guardarNoticiaRepository.deleteById(id);
    }

    public GuardarNoticia patch(Long id, GuardarNoticia parcialGuardarNoticia) {
    Optional<GuardarNoticia> guardarNoticiaOptional = guardarNoticiaRepository.findById(id);
    if (guardarNoticiaOptional.isPresent()) {
        GuardarNoticia guardarNoticiaToUpdate = guardarNoticiaOptional.get();

        if (parcialGuardarNoticia.getIdGuardarNoticia() != null) {
            guardarNoticiaToUpdate.setIdGuardarNoticia(parcialGuardarNoticia.getIdGuardarNoticia());
        }

        if (parcialGuardarNoticia.getCuenta() != null) {
            guardarNoticiaToUpdate.setCuenta(parcialGuardarNoticia.getCuenta());
        }

        if (parcialGuardarNoticia.getNoticia() != null) {
            guardarNoticiaToUpdate.setNoticia(parcialGuardarNoticia.getNoticia());
        }

        return guardarNoticiaRepository.save(guardarNoticiaToUpdate);
    } else {
        throw new RuntimeException("Guardado de noticia no encontrado con ID: " + id);
    }
}
}
