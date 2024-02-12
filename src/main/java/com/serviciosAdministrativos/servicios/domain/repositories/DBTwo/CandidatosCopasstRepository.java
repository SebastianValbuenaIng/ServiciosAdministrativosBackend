package com.serviciosAdministrativos.servicios.domain.repositories.DBTwo;

import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.CandidatosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatosCopasstRepository extends JpaRepository<CandidatosEntity, Integer> {
    @Query("SELECT e FROM CandidatosEntity e WHERE e.idcrp = 120")
    List<CandidatosEntity> findAllByIdcrp(@Param("idcrp") Integer idcrp);
}