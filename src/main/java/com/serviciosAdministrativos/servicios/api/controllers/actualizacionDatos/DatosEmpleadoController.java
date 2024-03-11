package com.serviciosAdministrativos.servicios.api.controllers.actualizacionDatos;

import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request.InformacionEmpleadoRequest;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos.DatosEmpleadoService;
import com.serviciosAdministrativos.servicios.util.errors.ServerError;
import com.serviciosAdministrativos.servicios.util.errors.ValidationErrorHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/datosEmpleado")
public class DatosEmpleadoController {
    private final DatosEmpleadoService datosEmpleadoService;

    public DatosEmpleadoController(DatosEmpleadoService datosEmpleadoService) {
        this.datosEmpleadoService = datosEmpleadoService;
    }

    @GetMapping
    public ResponseEntity<?> findDatosEmpleadoByDocumento(@RequestParam String documento) {
        try {
            return ResponseEntity.ok(datosEmpleadoService.findDatosEmpleadoByCoEmp(documento));
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @PostMapping
    public ResponseEntity<?> newDatosEmpleado(@RequestParam String documento,
                                              @RequestBody InformacionEmpleadoRequest informacionEmpleadoRequest) {
        try {
            return ResponseEntity.ok(datosEmpleadoService.newDatosEmpleadoToSave(documento, informacionEmpleadoRequest));
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }
}
