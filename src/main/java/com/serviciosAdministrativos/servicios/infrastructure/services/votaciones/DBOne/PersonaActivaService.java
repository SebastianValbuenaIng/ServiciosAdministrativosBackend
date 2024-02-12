package com.serviciosAdministrativos.servicios.infrastructure.services.votaciones.DBOne;

import com.serviciosAdministrativos.servicios.domain.entities.DBOne.PersonaActivaEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBOne.PersonaActivaRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IPersonaActivaService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(value = "db1TransactionManager", readOnly = true)
public class PersonaActivaService implements IPersonaActivaService {
    private final PersonaActivaRepository personaActivaRepository;

    public PersonaActivaService(PersonaActivaRepository personaActivaRepository) {
        this.personaActivaRepository = personaActivaRepository;
    }

    @Override
    public PersonaActivaEntity findByEmail(String email) {
        Optional<PersonaActivaEntity> personaActivaFind = personaActivaRepository.findByEmail(email);

        if (personaActivaFind.isEmpty()) throw new NotFoundError("Persona no encontrada");

        return personaActivaFind.get();
    }
}