
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

import com.PeorEsNada.cl.NoticieroExpress.model.GuardarNoticia;
import com.PeorEsNada.cl.NoticieroExpress.service.GuardarNoticiaService;

@RestController
@RequestMapping("/api/v1/guardar")
public class GuardarNoticiaController {

   @Autowired
    private GuardarNoticiaService guardarNoticiaService;

    @GetMapping
public ResponseEntity<List<GuardarNoticia>> listar() {
    List<GuardarNoticia> guardarNoticias = guardarNoticiaService.findAll();
    if (guardarNoticias.isEmpty()) {
        return ResponseEntity.noContent().build();
    }
    guardarNoticias.forEach(gn -> {
        if (gn.getCuenta() != null) {
            gn.getCuenta().setContraseñaCuenta("****");
        }
        if (gn.getNoticia() != null && gn.getNoticia().getAutor() != null) {
            gn.getNoticia().getAutor().setContraseñaAutor("****");
        }
    });

    return ResponseEntity.ok(guardarNoticias);
}

@GetMapping("/{id}")
public ResponseEntity<GuardarNoticia> buscar(@PathVariable Long id) {
    try {
        GuardarNoticia guardarNoticia = guardarNoticiaService.findById(id);

        if (guardarNoticia.getCuenta() != null) {
            guardarNoticia.getCuenta().setContraseñaCuenta("****");
        }
        if (guardarNoticia.getNoticia() != null && guardarNoticia.getNoticia().getAutor() != null) {
            guardarNoticia.getNoticia().getAutor().setContraseñaAutor("****");
        }

        return ResponseEntity.ok(guardarNoticia);
    } catch (Exception e) {
        return ResponseEntity.notFound().build();
    }
}

    @PostMapping
    public ResponseEntity<GuardarNoticia> guardar(@RequestBody GuardarNoticia guardarNoticia) {
        GuardarNoticia nueva = guardarNoticiaService.save(guardarNoticia);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
}


    @PutMapping("/{id}")
    public ResponseEntity<GuardarNoticia> actualizar(@PathVariable Long id, @RequestBody GuardarNoticia guardarNoticias) {
        try {
            guardarNoticiaService.save(guardarNoticias);
            return ResponseEntity.ok(guardarNoticias);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GuardarNoticia> patch(@PathVariable Long id, @RequestBody GuardarNoticia partialGuardarNoticia) {
        try {
            GuardarNoticia updatedGuardarNoticia = guardarNoticiaService.patch(id, partialGuardarNoticia);
            return ResponseEntity.ok(updatedGuardarNoticia);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            guardarNoticiaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}


