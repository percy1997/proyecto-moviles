package com.centroinformacion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.centroinformacion.entity.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

}
