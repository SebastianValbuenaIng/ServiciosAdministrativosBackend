package com.serviciosAdministrativos.servicios.api.controllers.actualizacionDatos;

import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request.AgregarPublicacionRequest;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos.PublicacionService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import com.serviciosAdministrativos.servicios.util.errors.ServerError;
import com.serviciosAdministrativos.servicios.util.errors.ValidationErrorHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/publicacionNueva")
public class PublicacionesController {
    private final PublicacionService publicacionService;

    public PublicacionesController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @GetMapping
    public ResponseEntity<?> getPublicacionesByCodEmpleado(@RequestParam String documento) {
        try {
            return ResponseEntity.ok(publicacionService.findAllPublicacionByEmpleado(documento));
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> postPublicacionNuevaByCodEmpleado(@RequestParam String documento,
                                                               @RequestBody AgregarPublicacionRequest agregarPublicacionRequest) {
        try {
            return ResponseEntity.ok(publicacionService.saveNewPublicacionEmpleado(documento, agregarPublicacionRequest));
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @PutMapping
    public ResponseEntity<?> putPublicacionNuevaByCodEmpleado(@RequestParam Integer id_publicacion,
                                                              @RequestBody AgregarPublicacionRequest agregarPublicacionRequest) {
        try {
            return ResponseEntity.ok(publicacionService.updateNewPublicacionEmpleado(id_publicacion, agregarPublicacionRequest));
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @DeleteMapping
    private ResponseEntity<?> deletePublicacionNuevaByEmpleado(@RequestParam Integer id_publicacion) {
        try {
            return ResponseEntity.ok(publicacionService.deleteNewPublicacionEmpleado(id_publicacion));
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }
}
