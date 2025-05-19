package com.PeorEsNada.cl.NoticieroExpress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PeorEsNada.cl.NoticieroExpress.model.Autor;
import com.PeorEsNada.cl.NoticieroExpress.repository.AutorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public Autor findById(long id) {
        return autorRepository.findById(id).get();
    }

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    public void delete (long id){
        autorRepository.deleteById(id);
    }
}
