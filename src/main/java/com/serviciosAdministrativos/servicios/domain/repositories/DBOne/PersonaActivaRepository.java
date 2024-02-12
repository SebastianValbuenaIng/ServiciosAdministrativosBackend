package com.serviciosAdministrativos.servicios.domain.repositories.DBOne;

import com.serviciosAdministrativos.servicios.domain.entities.DBOne.PersonaActivaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PersonaActivaRepository extends JpaRepository<PersonaActivaEntity, Integer> {
    @Query("SELECT e FROM PersonaActivaEntity e WHERE e.email = :email AND e.estado = 'Activo'")
    Optional<PersonaActivaEntity> findByEmail(@Param("email") String email);
}