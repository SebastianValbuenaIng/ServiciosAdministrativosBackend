package com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.RedesSocialesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RedesSocialesRepository extends CrudRepository<RedesSocialesEntity, Integer> {
    List<RedesSocialesEntity> findAllByCodEmp(String documento);
    Optional<RedesSocialesEntity> findByCodRedsocAndCodEmp(Integer cod_red_soc, String documento);
}
