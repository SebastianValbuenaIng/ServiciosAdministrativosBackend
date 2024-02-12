package com.serviciosAdministrativos.servicios.api.controllers.votaciones;

import com.serviciosAdministrativos.servicios.api.models.votaciones.request.VotoRequest;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICandidatosCclService;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.ICclService;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotacionesSecurity;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotoActionsService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import com.serviciosAdministrativos.servicios.util.errors.SecurityError;
import com.serviciosAdministrativos.servicios.util.errors.ValidationErrorHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ccl")
@CrossOrigin(origins = "*")
public class CclController {
    private final ICclService iCclService;
    private final IVotacionesSecurity iVotacionesSecurity;
    private final IVotoActionsService iVotoActionsService;
    private final ICandidatosCclService iCandidatosCclService;

    public CclController(ICclService iCclService,
                         IVotacionesSecurity iVotacionesSecurity,
                         IVotoActionsService iVotoActionsService,
                         ICandidatosCclService iCandidatosCclService) {
        this.iCclService = iCclService;
        this.iVotacionesSecurity = iVotacionesSecurity;
        this.iVotoActionsService = iVotoActionsService;
        this.iCandidatosCclService = iCandidatosCclService;
    }

    @GetMapping("/estado_voto")
    public ResponseEntity<?> get(@RequestParam String email) {
        try {
            return ResponseEntity.ok(iCclService.VerificarVotoCcl(email));
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        }
    }

    @GetMapping("/candidatos")
    public ResponseEntity<?> get() {
        try {
            return ResponseEntity.ok(iCandidatosCclService.buscarCandidatosCcl(121));
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        }
    }

    @PostMapping("/votar")
    public ResponseEntity<?> post(@RequestBody VotoRequest votacionesRequest, @RequestParam String email) {
        try {
            iVotacionesSecurity.userAuthorized(email);
            return ResponseEntity.ok(iVotoActionsService.save(votacionesRequest, email));
        } catch (SecurityError e) {
            return ValidationErrorHandler.handleValidation(e);
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}