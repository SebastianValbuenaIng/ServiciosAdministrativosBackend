package com.serviciosAdministrativos.servicios.api.controllers.actualizacionDatos;

import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request.AgregarFamiliarRequest;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos.FamiliarService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import com.serviciosAdministrativos.servicios.util.errors.ServerError;
import com.serviciosAdministrativos.servicios.util.errors.ValidationErrorHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/familiarNuevo")
public class FamiliarController {
    private final FamiliarService familiarService;

    public FamiliarController(FamiliarService familiarService) {
        this.familiarService = familiarService;
    }

    @GetMapping
    public ResponseEntity<?> getFamiliaresByCodEmpleado(@RequestParam String documento) {
        try {
            return ResponseEntity.ok(familiarService.findAllFamiliarByEmpleado(documento));
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> postFamiliarNuevoByCodEmpleado(@RequestParam String documento,
                                                            @RequestBody AgregarFamiliarRequest agregarFamiliarRequest) {
        try {
            return ResponseEntity.ok(familiarService.newFamiliarByEmpleado(documento, agregarFamiliarRequest));
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @PutMapping
    public ResponseEntity<?> putFamiliarNuevoByCodEmpleado(@RequestParam Integer id_familiar,
                                                           @RequestBody AgregarFamiliarRequest agregarFamiliarRequest) {
        try {
            return ResponseEntity.ok(familiarService.updateNewFamiliarByEmpleado(id_familiar, agregarFamiliarRequest));
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @DeleteMapping
    private ResponseEntity<?> deleteFamiliarNuevoByEmpleado(@RequestParam Integer id_familiar) {
        try {
            return ResponseEntity.ok(familiarService.deleteNewFamiliarByEmpleado(id_familiar));
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }
}
