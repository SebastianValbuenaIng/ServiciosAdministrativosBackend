package com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones;

import com.serviciosAdministrativos.servicios.domain.entities.DBOne.PersonaActivaEntity;

public interface IPersonaActivaService {
    PersonaActivaEntity findByEmail(String email);
}