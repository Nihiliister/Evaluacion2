package com.PeorEsNada.cl.NoticieroExpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PeorEsNada.cl.NoticieroExpress.model.Autor;
import com.PeorEsNada.cl.NoticieroExpress.service.AutorService;

@RestController
@RequestMapping("/api/v1/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> Listar() {
        List<Autor> autores = autorService.findAll();
        if(autores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(autores);
    }
    @PostMapping
    public ResponseEntity<Autor> guardar(@RequestBody Autor autor){
        Autor autorNuevo = autorService.save(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(autorNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscar(@PathVariable Integer id) {
        try {
            Autor autor = autorService.findById(id);
            return ResponseEntity.ok(autor);
        }catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizar(@PathVariable Integer id, @RequestBody Autor autor) {
        try {
            Autor aut = autorService.findById(id);
            aut.setIdAutor(id);
            aut.setNombreAutor(autor.getNombreAutor());
            aut.setCorreoAutor(autor.getCorreoAutor());
            aut.setContraseñaAutor(autor.getContraseñaAutor());

            autorService.save(aut);
            return ResponseEntity.ok(autor);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            autorService.delete(id);
            return ResponseEntity.noContent().build();
        }catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
