package com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.AreasInteresEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AreasInteresRepository extends CrudRepository<AreasInteresEntity, Integer> {
    List<AreasInteresEntity> findAllByCodEmp(String cod_emp);
    List<AreasInteresEntity> deleteAllByCodEmp(String cod_emp);
}
