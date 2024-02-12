package com.serviciosAdministrativos.servicios.domain.repositories.DBActualizacionDatos;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizacionDatos.GenClasif4Entity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenClasif4Repository extends CrudRepository<GenClasif4Entity, Integer> {
    List<GenClasif4Entity> findAllByEstado(String estado);
}