package com.serviciosAdministrativos.servicios.domain.repositories.DBTwo;

import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotacionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface VotacionesRepository extends JpaRepository<VotacionesEntity, Integer> {
}
