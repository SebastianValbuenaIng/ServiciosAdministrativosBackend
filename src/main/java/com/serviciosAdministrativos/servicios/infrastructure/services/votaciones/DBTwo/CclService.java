package com.serviciosAdministrativos.servicios.infrastructure.services.votaciones.DBTwo;

import com.serviciosAdministrativos.servicios.domain.entities.DBOne.PersonaActivaEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotanteEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBOne.PersonaActivaRepository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBTwo.VotanteRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICclService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional(value = "db2TransactionManager", readOnly = true)
public class CclService implements ICclService {

    private final VotanteRepository votanteRepository;
    private final PersonaActivaRepository personaActivaRepository;

    public CclService(VotanteRepository votanteRepository, PersonaActivaRepository personaActivaRepository) {
        this.votanteRepository = votanteRepository;
        this.personaActivaRepository = personaActivaRepository;
    }

    public Map<String, String> VerificarVotoCcl(String email) {
        Optional<PersonaActivaEntity> personaActivaFind = personaActivaRepository.findByEmail(email);

        if (personaActivaFind.isEmpty()) throw new NotFoundError("Email no encontrado");

        Optional<VotanteEntity> votanteFind = votanteRepository.findByIdentificacion(personaActivaFind.get().getNroDocumento());

        if (votanteFind.isEmpty()) throw new NotFoundError("No se han encontrado Votaciones");

        Map<String, String> estado = new HashMap<>();
        estado.put("estado", votanteFind.get().getCcl().toString());
        return estado;
    }
}
