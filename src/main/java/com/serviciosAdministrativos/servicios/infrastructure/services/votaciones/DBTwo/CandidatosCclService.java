package com.serviciosAdministrativos.servicios.infrastructure.services.votaciones.DBTwo;

import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.CandidatosEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBTwo.CandidatosCclRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICandidatosCclService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(value = "db2TransactionManager", readOnly = true)
public class CandidatosCclService implements ICandidatosCclService {
    private final CandidatosCclRepository candidatosCclRepository;

    public CandidatosCclService(CandidatosCclRepository candidatosCclRepository) {
        this.candidatosCclRepository = candidatosCclRepository;
    }

    public List<CandidatosEntity> buscarCandidatosCcl(Integer idcrp) {
        List<CandidatosEntity> buscarCandidatosCcl = candidatosCclRepository.findByIdcrp(idcrp);

        if (buscarCandidatosCcl.isEmpty())
            throw new NotFoundError("No se encontraron votaciones con ese código");

        return buscarCandidatosCcl;
    }
}
