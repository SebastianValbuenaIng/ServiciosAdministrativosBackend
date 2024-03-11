package com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.FamiliaEmpleadoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FamiliaEmpleadoRepository extends CrudRepository<FamiliaEmpleadoEntity, Integer> {
    List<FamiliaEmpleadoEntity> findByCodEmp(String documento);
}
