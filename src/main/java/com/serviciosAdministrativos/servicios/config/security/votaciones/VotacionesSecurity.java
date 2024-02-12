package com.serviciosAdministrativos.servicios.config.security.votaciones;

import com.serviciosAdministrativos.servicios.domain.entities.DBOne.PersonaActivaEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBOne.PersonaActivaRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotacionesSecurity;
import com.serviciosAdministrativos.servicios.util.errors.SecurityError;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(value = "db1TransactionManager", readOnly = true)
public class VotacionesSecurity implements IVotacionesSecurity {
    private final PersonaActivaRepository personaActivaRepository;

    public VotacionesSecurity(PersonaActivaRepository personaActivaRepository) {
        this.personaActivaRepository = personaActivaRepository;
    }

    public void userAuthorized(String email) {
        Optional<PersonaActivaEntity> personaActivaFind = personaActivaRepository
                .findByEmail(email);

        if (personaActivaFind.isEmpty())
            throw new SecurityError("No tienes permisos para continuar");
    }
}
