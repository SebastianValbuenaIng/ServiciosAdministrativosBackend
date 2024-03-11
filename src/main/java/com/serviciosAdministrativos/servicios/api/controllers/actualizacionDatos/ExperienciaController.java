package com.serviciosAdministrativos.servicios.api.controllers.actualizacionDatos;

import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request.ExperienciaRequest;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos.ExperienciaService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import com.serviciosAdministrativos.servicios.util.errors.ServerError;
import com.serviciosAdministrativos.servicios.util.errors.ValidationErrorHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/experienciaNueva")
public class ExperienciaController {
    private final ExperienciaService experienciaService;

    public ExperienciaController(ExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }

    @GetMapping
    public ResponseEntity<?> getExperienciaNuevaByCodEmpleado(@RequestParam String documento) {
        try {
            return ResponseEntity.ok(experienciaService.findAllExperienciasByEmpleado(documento));
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> postExperienciaNuevaByCodEmpleado(@RequestParam String documento,
                                                               @RequestBody ExperienciaRequest experienciaRequest) {
        try {
            return ResponseEntity.ok(experienciaService.saveNewExperienceEmpleado(documento, experienciaRequest));
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @PutMapping
    public ResponseEntity<?> putExperienciaNuevaByCodEmpleado(@RequestParam Integer id_experiencia,
                                                              @RequestBody ExperienciaRequest experienciaRequest) {
        try {
            return ResponseEntity.ok(experienciaService.updateNewExperienceEmpleado(id_experiencia, experienciaRequest));
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @DeleteMapping
    private ResponseEntity<?> deleteExperienciaNuevaByEmpleado(@RequestParam Integer id_experiencia) {
        try {
            return ResponseEntity.ok(experienciaService.deleteNewExperienceEmpleado(id_experiencia));
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }
}
