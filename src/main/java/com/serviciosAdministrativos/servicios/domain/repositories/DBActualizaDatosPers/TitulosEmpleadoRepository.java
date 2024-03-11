package com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.TitulosEmpleadoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TitulosEmpleadoRepository extends CrudRepository<TitulosEmpleadoEntity, Integer> {
    List<TitulosEmpleadoEntity> findAllByCodEmp(String documento);
    Integer countAllByCodEmp(String documento);
    @Query(value = "SELECT TOP 1 * FROM Titulos_Empleado WHERE cod_emp = :documento ORDER BY id desc", nativeQuery = true)
    Optional<TitulosEmpleadoEntity> findLastTitulosEmpleadoById(String documento);
}