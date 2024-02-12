package com.serviciosAdministrativos.servicios.infrastructure.services.votaciones.DBTwo;

import com.serviciosAdministrativos.servicios.api.models.votaciones.request.VotoRequest;
import com.serviciosAdministrativos.servicios.domain.entities.DBOne.PersonaActivaEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotacionesEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBTwo.VotanteEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBOne.PersonaActivaRepository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBTwo.VotacionesRepository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBTwo.VotanteRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotoActionsService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional("db2TransactionManager")
public class VotoActionsService implements IVotoActionsService {
    private final VotanteRepository votanteRepository;
    private final VotacionesRepository votacionesRepository;
    private final PersonaActivaRepository personaActivaRepository;

    public VotoActionsService(VotanteRepository votanteRepository,
                              VotacionesRepository votacionesRepository,
                              PersonaActivaRepository personaActivaRepository) {
        this.votanteRepository = votanteRepository;
        this.votacionesRepository = votacionesRepository;
        this.personaActivaRepository = personaActivaRepository;
    }

    @Override
    public Map<String, String> save(VotoRequest votoRequest, String email) {
        Optional<PersonaActivaEntity> votanteFindEmail = personaActivaRepository.findByEmail(email);

        if (votanteFindEmail.isEmpty()) throw new NotFoundError("No existe en personas activas");

        Optional<VotanteEntity> votanteFind = votanteRepository.findByIdentificacion(votanteFindEmail.get().getNroDocumento());

        if (votanteFind.isEmpty()) throw new NotFoundError("No existe en votante");

        for (Integer nroton : votoRequest.getCandidatos()) {
            VotacionesEntity saveVotaciones = new VotacionesEntity(
                    votoRequest.getIdcrp(),
                    nroton,
                    LocalDateTime.now(),
                    votoRequest.getPeriodo()
            );

            votacionesRepository.save(saveVotaciones);

            if (votanteFind.get().getCcl() != null && votanteFind.get().getCcl() == 0 && votoRequest.getIdcrp() == 121) {
                votanteFind.get().setCcl(1);
                votanteFind.get().setFecha_ccl(LocalDate.now());
            } else if ((votanteFind.get().getCopasst() != null && votanteFind.get().getCopasst() == 0) && votoRequest.getIdcrp() == 120) {
                votanteFind.get().setCopasst(1);
                votanteFind.get().setFecha_copasst(LocalDate.now());
            }

            votanteRepository.save(votanteFind.get());
        }

        return Collections.singletonMap("message", "Se guardó correctamente");
    }
}
