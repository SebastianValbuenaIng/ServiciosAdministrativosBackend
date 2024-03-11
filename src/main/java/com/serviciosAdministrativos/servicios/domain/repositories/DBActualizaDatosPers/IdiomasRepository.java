package com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.IdiomasEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IdiomasRepository extends CrudRepository<IdiomasEntity, Integer> {
    List<IdiomasEntity> findAllByCodEmp(String documento);
}
