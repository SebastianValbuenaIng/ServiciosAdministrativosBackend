package com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.FechasEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FechasRepository extends CrudRepository<FechasEntity, Integer> {
    @Query(value = "select TOP 1 * from Fechas ORDER BY id desc ", nativeQuery = true)
    Optional<FechasEntity> findFirstFecha();
}
