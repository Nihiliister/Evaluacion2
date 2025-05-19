package com.PeorEsNada.cl.NoticieroExpress.service;


import java.util.List;

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

    public Noticia findById(long id) {
        return noticiaRepository.findById(id).get();
    }

    public Noticia save(Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    public void delete(long id){
        noticiaRepository.deleteById(id);
    }
}
