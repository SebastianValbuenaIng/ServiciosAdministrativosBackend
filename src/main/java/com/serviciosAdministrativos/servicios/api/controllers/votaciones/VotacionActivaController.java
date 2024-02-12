package com.serviciosAdministrativos.servicios.api.controllers.votaciones;

import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotacionActivaService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import com.serviciosAdministrativos.servicios.util.errors.SecurityError;
import com.serviciosAdministrativos.servicios.util.errors.ValidationErrorHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vot_act")
public class VotacionActivaController {
    private final IVotacionActivaService iVotacionActivaService;

    public VotacionActivaController(IVotacionActivaService iVotacionActivaService) {
        this.iVotacionActivaService = iVotacionActivaService;
    }

    @GetMapping
    public ResponseEntity<?> get(@RequestParam Integer estado, @RequestParam String email) {
        try {
            return ResponseEntity.ok(iVotacionActivaService.buscarVotaciones(estado, email));
        } catch (SecurityError e) {
            return ValidationErrorHandler.handleValidation(e);
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        }
    }
}