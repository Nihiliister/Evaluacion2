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

import com.PeorEsNada.cl.NoticieroExpress.model.Cuenta;
import com.PeorEsNada.cl.NoticieroExpress.service.CuentaService;

@RestController
@RequestMapping("/api/v1/cuentas")
public class CuentaController {
@Autowired
    private CuentaService cuentaService;

    @GetMapping
    public ResponseEntity<List<Cuenta>> listar() {
        List<Cuenta> cuentas = cuentaService.findAll();
        if (cuentas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
    cuentas.forEach(u -> u.setContraseñaCuenta("****"));
    return ResponseEntity.ok(cuentas);
}


    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> buscar(@PathVariable Long id) {
        try {
            Cuenta cuenta = cuentaService.findById(id);
            
            cuenta.setContraseñaCuenta("****");
            return ResponseEntity.ok(cuenta);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cuenta> guardar(@RequestBody Cuenta cuenta) {
        Cuenta cuentaNueva = cuentaService.save(cuenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(cuentaNueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> actualizar(@PathVariable Long id, @RequestBody Cuenta cuenta) {
        try {
            cuentaService.save(cuenta);
            return ResponseEntity.ok(cuenta);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cuenta> patchCuenta(@PathVariable Long id, @RequestBody Cuenta partialCuenta) {
        try {
            Cuenta updatedCuenta = cuentaService.patchCuenta(id, partialCuenta);
            return ResponseEntity.ok(updatedCuenta);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            cuentaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
