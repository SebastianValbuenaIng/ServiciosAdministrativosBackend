package com.serviciosAdministrativos.servicios.api.controllers.actualizacionDatos;

import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos.AreasInteresService;
import com.serviciosAdministrativos.servicios.util.errors.ServerError;
import com.serviciosAdministrativos.servicios.util.errors.ValidationErrorHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/areasInteres")
public class AreasInteresController {
    private final AreasInteresService areasInteresService;

    public AreasInteresController(AreasInteresService areasInteresService) {
        this.areasInteresService = areasInteresService;
    }

    @GetMapping
    public ResponseEntity<?> getAreasInteres(@RequestParam String documento) {
        try {
            return ResponseEntity.ok(areasInteresService.getAllAreasInteres(documento));
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> postAreasInteres(@RequestParam String documento, @RequestBody List<String> areas_interes) {
        try {
            return ResponseEntity.ok(areasInteresService.postAreasInteres(documento, areas_interes));
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }
}
