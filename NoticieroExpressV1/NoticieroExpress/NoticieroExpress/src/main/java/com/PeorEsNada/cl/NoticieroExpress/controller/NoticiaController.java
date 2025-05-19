package com.PeorEsNada.cl.NoticieroExpress.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.PeorEsNada.cl.NoticieroExpress.model.Noticia;
import com.PeorEsNada.cl.NoticieroExpress.service.NoticiaService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/noticias")

public class NoticiaController {

    @Autowired
    private NoticiaService noticiaService;

    @GetMapping
    public ResponseEntity<List<Noticia>> Listar() {
        List<Noticia> noticias = noticiaService.findAll();
        if (noticias.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(noticias);

    }

    @PostMapping
    public ResponseEntity<Noticia> guardar(@RequestBody Noticia noticia){
        Noticia noticiaNueva = noticiaService.save(noticia);
        return ResponseEntity.status(HttpStatus.CREATED).body(noticiaNueva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Noticia> buscar(@PathVariable Integer id){
        try {
            Noticia noticia = noticiaService.findById(id);
            return ResponseEntity.ok(noticia);
        }catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Noticia> actualizar(@PathVariable Integer id, @RequestBody Noticia noticia) {
        try {
            Noticia not = noticiaService.findById(id);
            not.setIdNoticia(id);
            not.setTitulo(noticia.getTitulo());
            not.setFechaPublicacion(noticia.getFechaPublicacion());
            not.setAutor(noticia.getAutor());

            noticiaService.save(not);
            return ResponseEntity.ok(noticia);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            noticiaService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
