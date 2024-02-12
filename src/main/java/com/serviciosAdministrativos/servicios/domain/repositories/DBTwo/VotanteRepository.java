package com.serviciosAdministrativos.servicios.domain.repositories.DBTwo;

import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VotanteRepository extends JpaRepository<VotanteEntity, Integer> {
    @Query(value = "SELECT * FROM Votaciones.vot.votantes WHERE identificacion = :identificacion", nativeQuery = true)
    Optional<VotanteEntity> findByIdentificacion(@Param("identificacion") String identificacion);
}
