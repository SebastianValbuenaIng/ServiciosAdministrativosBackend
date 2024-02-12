package com.serviciosAdministrativos.servicios.infrastructure.services.votaciones.DBTwo;

import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.CandidatosEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBTwo.CandidatosCopasstRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICandidatosCopasstService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(value = "db2TransactionManager", readOnly = true)
public class CandidatosCopasstService implements ICandidatosCopasstService {
    private final CandidatosCopasstRepository candidatosCopasstRepository;

    public CandidatosCopasstService(CandidatosCopasstRepository candidatosCopasstRepository) {
        this.candidatosCopasstRepository = candidatosCopasstRepository;
    }

    public List<CandidatosEntity> buscarCandidatos() {
        List<CandidatosEntity> buscarCandidatos = candidatosCopasstRepository.findAllByIdcrp(120);

        if (buscarCandidatos.isEmpty()) throw new NotFoundError("No se encontraron votaciones con ese código");

        return buscarCandidatos;
    }
}