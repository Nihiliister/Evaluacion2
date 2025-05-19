package com.PeorEsNada.cl.NoticieroExpress.repository;

import com.PeorEsNada.cl.NoticieroExpress.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Long>{

    List<Cuenta> findAll();

   

    Cuenta findByIdCuenta(Integer idCuenta);
    Cuenta findByCorreoCuenta(String correoCuenta);
    Cuenta findByContraseñaCuenta(String contraseñaCuenta);
    Cuenta findByNombreCuenta(String nombreCuenta);
}
