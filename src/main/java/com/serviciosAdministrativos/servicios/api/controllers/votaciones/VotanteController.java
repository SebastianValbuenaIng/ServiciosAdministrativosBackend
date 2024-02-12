package com.serviciosAdministrativos.servicios.api.controllers.votaciones;

import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.votaciones.IVotanteService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import com.serviciosAdministrativos.servicios.util.errors.ValidationErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")

public class VotanteController {
    private final IVotanteService iVotanteService;

    public VotanteController(IVotanteService iVotanteService) {
        this.iVotanteService = iVotanteService;
    }

    @GetMapping
    public ResponseEntity<?> get(@RequestParam String email) {
        try {
            Map<String, String> result = new HashMap<>();
            result.put("estado_Voto", iVotanteService.buscarVotaciones(email));
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        }
    }
}