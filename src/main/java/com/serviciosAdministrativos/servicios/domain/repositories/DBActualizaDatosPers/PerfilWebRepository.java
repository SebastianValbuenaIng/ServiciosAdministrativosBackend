package com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.PerfilWebEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PerfilWebRepository extends CrudRepository<PerfilWebEntity, Integer> {
    Optional<PerfilWebEntity> findByCodEmp(String documento);
}
