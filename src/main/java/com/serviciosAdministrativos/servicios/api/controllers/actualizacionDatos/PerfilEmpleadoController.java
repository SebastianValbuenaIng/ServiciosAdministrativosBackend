package com.serviciosAdministrativos.servicios.api.controllers.actualizacionDatos;

import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request.PerfilWebRequest;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos.PerfilEmpleadoService;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos.PerfilWebService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import com.serviciosAdministrativos.servicios.util.errors.ServerError;
import com.serviciosAdministrativos.servicios.util.errors.ValidationErrorHandler;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/nuevoPerfil")
public class PerfilEmpleadoController {
    private final PerfilEmpleadoService perfilEmpleadoService;
    private final PerfilWebService perfilWebService;

    public PerfilEmpleadoController(PerfilEmpleadoService perfilEmpleadoService,
                                    PerfilWebService perfilWebService) {
        this.perfilEmpleadoService = perfilEmpleadoService;
        this.perfilWebService = perfilWebService;
    }

    @GetMapping("/titulos")
    public ResponseEntity<?> getTitulosPregrado(@RequestParam String documento) {
        try {
            return ResponseEntity.ok(perfilEmpleadoService.findAllTitulosPregrado(documento));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/nuevoTitulo")
    public ResponseEntity<?> getNuevoTitulo(
            @RequestParam String nombre,
            @RequestParam String documento,
            @RequestParam String cod_estudio,
            @RequestParam MultipartFile[] archivo,
            @RequestParam String cod_ins,
            @RequestParam Integer ano_est,
            @RequestParam LocalDate fec_gra,
            @RequestParam(required = false) String nro_tar) {
        try {
            return ResponseEntity.ok(perfilEmpleadoService.newTituloEmpleado(nombre, documento, cod_estudio, archivo, cod_ins, ano_est, fec_gra, nro_tar));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/titulo")
    public ResponseEntity<?> getTituloDocument(HttpServletResponse response, @RequestParam String name_title) {
        try {
            perfilEmpleadoService.getTituloDocumento(name_title, response);
            return ResponseEntity.ok().build();
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @DeleteMapping("/nuevoTitulo")
    public ResponseEntity<?> deleteTitulo(@RequestParam Integer id_titulo) {
        try {
            return ResponseEntity.ok(perfilEmpleadoService.deleteTituloEmpleado(id_titulo));
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        }
    }

    @PutMapping("/nuevoTitulo")
    public ResponseEntity<?> putNuevoTitulo(@RequestParam Integer id_titulo,
                                            @RequestParam String nombre,
                                            @RequestParam String cod_estudio,
                                            @RequestParam(required = false) MultipartFile[] archivo,
                                            @RequestParam String cod_ins,
                                            @RequestParam Integer ano_est,
                                            @RequestParam LocalDate fec_gra,
                                            @RequestParam(required = false) String nro_tar) {
        try {
            return ResponseEntity.ok(perfilEmpleadoService.updateTituloEmpleado(id_titulo, nombre, cod_estudio, archivo, cod_ins, ano_est, fec_gra, nro_tar));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/perfilWeb")
    public ResponseEntity<?> getPerfilWeb(@RequestParam String documento) {
        try {
            return ResponseEntity.ok(perfilWebService.getPerfilWeb(documento));
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }

    @PostMapping("/perfilWeb")
    public ResponseEntity<?> postPerfilWeb(@RequestParam String documento, @RequestBody PerfilWebRequest perfilWebRequest) {
        try {
            return ResponseEntity.ok(perfilWebService.postPerfilWeb(documento, perfilWebRequest));
        } catch (NotFoundError e) {
            return ValidationErrorHandler.handleNotFound(e);
        } catch (ServerError e) {
            return ValidationErrorHandler.handleException(e);
        }
    }
}
