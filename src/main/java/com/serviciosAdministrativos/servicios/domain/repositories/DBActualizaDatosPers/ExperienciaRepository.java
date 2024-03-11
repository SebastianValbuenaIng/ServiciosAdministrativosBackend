package com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.ExperienciaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExperienciaRepository extends CrudRepository<ExperienciaEntity, Integer> {
    List<ExperienciaEntity> findAllByCodEmp(String documento);
}
