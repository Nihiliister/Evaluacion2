package com.PeorEsNada.cl.NoticieroExpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PeorEsNada.cl.NoticieroExpress.model.Noticia;
import com.PeorEsNada.cl.NoticieroExpress.service.NoticiaService;

@RestController
@RequestMapping("/api/v1/noticias")
public class NoticiaController {

    @Autowired
    private NoticiaService noticiaService;

     @GetMapping
public ResponseEntity<List<Noticia>> listar() {
    List<Noticia> noticias = noticiaService.findAll();
    if (noticias.isEmpty()) {
        return ResponseEntity.noContent().build();
    }
    noticias.forEach(noticia -> {
        if (noticia.getAutor() != null) {
            noticia.getAutor().setContraseñaAutor("****");
        }
    });

    return ResponseEntity.ok(noticias);
}

    @GetMapping("/{id}")
public ResponseEntity<Noticia> buscar(@PathVariable Long id) {
    try {
        Noticia noticia = noticiaService.findById(id);
        if (noticia.getAutor() != null) {
            noticia.getAutor().setContraseñaAutor("****");
        }
        return ResponseEntity.ok(noticia);
    } catch (Exception e) {
        return ResponseEntity.notFound().build();
    }
}

    @PostMapping
    public ResponseEntity<Noticia> guardar(@RequestBody Noticia noticia) {
        Noticia noticiaNueva = noticiaService.save(noticia);
        return ResponseEntity.status(HttpStatus.CREATED).body(noticiaNueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Noticia> actualizar(@PathVariable Long id, @RequestBody Noticia noticia) {
        try {
            noticiaService.save(noticia);
            return ResponseEntity.ok(noticia);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Noticia> patchNoticia(@PathVariable Long id, @RequestBody Noticia partialNoticia) {
        try {
            Noticia updatedNoticia = noticiaService.patchNoticia(id, partialNoticia);
            return ResponseEntity.ok(updatedNoticia);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            noticiaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}