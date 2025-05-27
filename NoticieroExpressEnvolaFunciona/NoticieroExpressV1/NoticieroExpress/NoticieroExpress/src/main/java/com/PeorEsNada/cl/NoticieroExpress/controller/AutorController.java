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

import com.PeorEsNada.cl.NoticieroExpress.model.Autor;
import com.PeorEsNada.cl.NoticieroExpress.service.AutorService;

@RestController
@RequestMapping("/api/v1/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;


    @GetMapping
    public ResponseEntity<List<Autor>> listar() {
        List<Autor> autores = autorService.findAll();
        if (autores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        autores.forEach(u -> u.setContraseñaAutor("****"));

        return ResponseEntity.ok(autores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscar(@PathVariable Long id) {
        try {
            Autor autor = autorService.findById(id);
            autor.setContraseñaAutor("****");
            return ResponseEntity.ok(autor);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Autor> guardar(@RequestBody Autor autor) {
        Autor autorNuevo = autorService.save(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(autorNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizar(@PathVariable Long id, @RequestBody Autor autor) {
        try {
            autorService.save(autor);
            return ResponseEntity.ok(autor);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Autor> patchAutor(@PathVariable Long id, @RequestBody Autor partialAutor) {
        try {
            Autor updatedAutor = autorService.patchAutor(id, partialAutor);
            return ResponseEntity.ok(updatedAutor);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            autorService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

   