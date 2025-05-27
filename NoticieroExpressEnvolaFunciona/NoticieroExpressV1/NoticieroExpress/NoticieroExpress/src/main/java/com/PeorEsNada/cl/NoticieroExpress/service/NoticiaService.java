package com.PeorEsNada.cl.NoticieroExpress.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PeorEsNada.cl.NoticieroExpress.model.Noticia;
import com.PeorEsNada.cl.NoticieroExpress.repository.NoticiaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    public List<Noticia> findAll() {
        return noticiaRepository.findAll();
    }

    public Noticia findById(Long id) {
        return noticiaRepository.findById(id).get();
    }

    public Noticia save(Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    public void delete(Long id){
        noticiaRepository.deleteById(id);
    }

    public Noticia patchNoticia(Long id, Noticia parcialNoticia) {
    Optional<Noticia> noticiaOptional = noticiaRepository.findById(id);
    if (noticiaOptional.isPresent()) {
        Noticia noticiaToUpdate = noticiaOptional.get();

        if (parcialNoticia.getTitulo() != null) {
            noticiaToUpdate.setTitulo(parcialNoticia.getTitulo());
        }

        if (parcialNoticia.getFechaPublicacion() != null) {
            noticiaToUpdate.setFechaPublicacion(parcialNoticia.getFechaPublicacion());
        }

        if (parcialNoticia.getAutor() != null) {
            noticiaToUpdate.setAutor(parcialNoticia.getAutor());
        }

        return noticiaRepository.save(noticiaToUpdate);
    } else {
        throw new RuntimeException("Noticia no encontrada con ID: " + id);
    }
}


    
}
