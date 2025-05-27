package com.PeorEsNada.cl.NoticieroExpress.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PeorEsNada.cl.NoticieroExpress.model.Cuenta;

import com.PeorEsNada.cl.NoticieroExpress.repository.CuentaRepository;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class CuentaService {
@Autowired
    private CuentaRepository cuentaRepository;

    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    public Cuenta findById(Long id) {
        return cuentaRepository.findById(id).get();
    }

    public Cuenta save(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public void delete(Long id){
        cuentaRepository.deleteById(id);
    }

    public Cuenta patchCuenta(Long id, Cuenta parcialCuenta) {
        Optional<Cuenta> cuentaOptional = cuentaRepository.findById(id);
        if (cuentaOptional.isPresent()){
            Cuenta cuentaToUpdate = cuentaOptional.get();

        if (parcialCuenta.getNombreCuenta() != null) {
            cuentaToUpdate.setNombreCuenta(parcialCuenta.getNombreCuenta());
        }

        if (parcialCuenta.getCorreoCuenta() != null) {
            cuentaToUpdate.setCorreoCuenta(parcialCuenta.getCorreoCuenta());
        }

        if (parcialCuenta.getContraseñaCuenta() != null) {
            cuentaToUpdate.setContraseñaCuenta(parcialCuenta.getContraseñaCuenta());
        }

        return cuentaRepository.save(cuentaToUpdate);
        } else {
            throw new RuntimeException("Cuenta no encontrada con ID: " + id);
        }
    }
}
