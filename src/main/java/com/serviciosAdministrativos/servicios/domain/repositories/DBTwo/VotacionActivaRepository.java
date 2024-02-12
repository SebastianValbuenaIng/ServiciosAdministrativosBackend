package com.serviciosAdministrativos.servicios.domain.repositories.DBTwo;

import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotacionActivaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotacionActivaRepository extends JpaRepository<VotacionActivaEntity, Integer> {
    @Query("SELECT e FROM VotacionActivaEntity e WHERE e.estado = ?1 and e.tprep in (2)")
    List<VotacionActivaEntity> findAllByEstado(@Param("estado") Integer estado);
}
