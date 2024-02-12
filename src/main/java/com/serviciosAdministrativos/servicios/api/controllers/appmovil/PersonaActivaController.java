package com.serviciosAdministrativos.servicios.api.controllers.appmovil;

import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IPersonaActivaService;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotacionesSecurity;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import com.serviciosAdministrativos.servicios.util.errors.SecurityError;
import com.serviciosAdministrativos.servicios.util.errors.ValidationErrorHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/personas")
public class PersonaActivaController {
    private final IPersonaActivaService iPersonaActivaService;
    private final IVotacionesSecurity iVotacionesSecurity;

    public PersonaActivaController(IPersonaActivaService iPersonaActivaService, IVotacionesSecurity iVotacionesSecurity) {
        this.iPersonaActivaService = iPersonaActivaService;
        this.iVotacionesSecurity = iVotacionesSecurity;
    }

    @GetMapping
    public ResponseEntity<?> get(@RequestParam String email) {
        try {
            iVotacionesSecurity.userAuthorized(email);
            return ResponseEntity.ok(iPersonaActivaService.findByEmail(email));
        } catch (SecurityError e) {
            return ValidationErrorHandler.handleValidation(e);
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        }
    }
}
