package com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.PublicacionesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PublicacionesRepository extends CrudRepository<PublicacionesEntity, Integer> {
    List<PublicacionesEntity> findAllByCodEmp(String documento);
}
