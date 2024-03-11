package com.serviciosAdministrativos.servicios.api.controllers.actualizacionDatos;

import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request.AgregarIdiomaRequest;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos.IdiomaService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import com.serviciosAdministrativos.servicios.util.errors.ServerError;
import com.serviciosAdministrativos.servicios.util.errors.ValidationErrorHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/nuevoIdioma")
public class IdiomaController {
    private final IdiomaService idiomaService;

    public IdiomaController(IdiomaService idiomaService) {
        this.idiomaService = idiomaService;
    }

    @GetMapping
    public ResponseEntity<?> getNuevosIdiomasByEmpleado(@RequestParam String documento) {
        try {
            return ResponseEntity.ok(idiomaService.findAllIdiomasByEmpleado(documento));
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> postNuevoIdioma(@RequestParam String documento, @RequestBody AgregarIdiomaRequest agregarIdiomaRequest) {
        try {
            return ResponseEntity.ok(idiomaService.saveNewIdiomaEmpleado(documento, agregarIdiomaRequest));
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @PutMapping
    public ResponseEntity<?> putIdiomaNuevoByCodEmpleado(@RequestParam Integer id_idioma,
                                                         @RequestBody AgregarIdiomaRequest agregarIdiomaRequest) {
        try {
            return ResponseEntity.ok(idiomaService.updateNewIdiomaEmpleado(id_idioma, agregarIdiomaRequest));
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @DeleteMapping
    private ResponseEntity<?> deleteIdiomaNuevoByEmpleado(@RequestParam Integer id_idioma) {
        try {
            return ResponseEntity.ok(idiomaService.deleteNewIdiomaEmpleado(id_idioma));
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }
}
