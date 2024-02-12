package com.serviciosAdministrativos.servicios.infrastructure.services.votaciones.DBTwo;

import com.serviciosAdministrativos.servicios.domain.entities.DBOne.PersonaActivaEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotacionActivaEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotanteEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBOne.PersonaActivaRepository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBTwo.VotacionActivaRepository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBTwo.VotanteRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotacionActivaService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(value = "db2TransactionManager")
public class VotacionActivaService implements IVotacionActivaService {
    private final VotacionActivaRepository votacionActivaRepository;
    private final VotanteRepository votanteRepository;
    private final PersonaActivaRepository personaActivaRepository;

    public VotacionActivaService(VotanteRepository votanteRepository, VotacionActivaRepository votacionActivaRepository, PersonaActivaRepository personaActivaRepository) {
        this.votacionActivaRepository = votacionActivaRepository;
        this.personaActivaRepository = personaActivaRepository;
        this.votanteRepository = votanteRepository;
    }

    public List<Map<String, String>> buscarVotaciones(Integer estado, String email) {
        Optional<PersonaActivaEntity> personaActivaFind = personaActivaRepository.findByEmail(email);

        if (personaActivaFind.isEmpty()) throw new NotFoundError("email no encontrado");

        Optional<VotanteEntity> votanteFind = votanteRepository.findByIdentificacion(personaActivaFind.get().getNroDocumento());

        if (votanteFind.isEmpty()) throw new NotFoundError("No existe en votante");

        List<VotacionActivaEntity> votacionesActivas = votacionActivaRepository.findAllByEstado(estado);

        if (votacionesActivas.isEmpty()) throw new NotFoundError("No se han encontrado Votaciones");

        List<Map<String, String>> votacionesPersona = new ArrayList<>();

        for (VotacionActivaEntity votacion : votacionesActivas) {
            Map<String, String> nuevaVotacion = new HashMap<>();
            nuevaVotacion.put("id", votacion.getId().toString());
            nuevaVotacion.put("nombre", votacion.getNombre());

            if (votacion.getId() == 1) {
                nuevaVotacion.put("estado_voto", votanteFind.get().getCopasst().toString());
                nuevaVotacion.put("ruta", "/votcopasst");
            } else if (votacion.getId() == 3) {
                nuevaVotacion.put("estado_voto", votanteFind.get().getCcl().toString());
                nuevaVotacion.put("ruta", "/ccl");
            } else {
                nuevaVotacion.put("estado_voto", "0");
            }

            votacionesPersona.add(nuevaVotacion);
        }

        return votacionesPersona;
    }
}