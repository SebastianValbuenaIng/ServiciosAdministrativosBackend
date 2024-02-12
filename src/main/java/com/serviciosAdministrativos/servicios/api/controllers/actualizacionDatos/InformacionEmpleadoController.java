package com.serviciosAdministrativos.servicios.api.controllers.actualizacionDatos;

import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizacionDatos.GTHEstadoCivilRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/empleado")
public class InformacionEmpleadoController {
    private final GTHEstadoCivilRepository gthInformacionEmpleado;

    public InformacionEmpleadoController(GTHEstadoCivilRepository gthInformacionEmpleado) {
        this.gthInformacionEmpleado = gthInformacionEmpleado;
    }

    @GetMapping("/informacionEmpleado")
    public Map<String, Object> getInfoEmpleado(@RequestParam String documento) {
        try {
            Map<String, Object> responseInfoEmpleado = gthInformacionEmpleado.getInformacionEmpleado(documento);

            Map<String, Object> infoEmpleado = new LinkedHashMap<>();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            infoEmpleado.put("nom_ciu", responseInfoEmpleado.get("nom_ciu").toString().trim());
            infoEmpleado.put("depto_res", responseInfoEmpleado.get("depto_res").toString().trim());
            infoEmpleado.put("dir_res", responseInfoEmpleado.get("dir_res").toString().trim());
            infoEmpleado.put("tipo_doc", responseInfoEmpleado.get("tipo_doc").toString().trim());
            infoEmpleado.put("cod_emp", responseInfoEmpleado.get("cod_emp").toString().trim());
            infoEmpleado.put("pais_residencia", responseInfoEmpleado.get("pais_residencia").toString().trim());
            infoEmpleado.put("fecha_nacimiento", LocalDate.parse(responseInfoEmpleado.get("fecha_nacimiento").toString(), formatter));
            infoEmpleado.put("nombres", responseInfoEmpleado.get("nombres"));
            infoEmpleado.put("tel_celular", responseInfoEmpleado.get("tel_celular"));
            infoEmpleado.put("categoria", responseInfoEmpleado.get("categoria"));
            infoEmpleado.put("email_alterno", responseInfoEmpleado.get("email_alterno"));
            infoEmpleado.put("des_gen", responseInfoEmpleado.get("des_gen"));
            infoEmpleado.put("tel_res", responseInfoEmpleado.get("tel_res"));
            infoEmpleado.put("email", responseInfoEmpleado.get("email"));
            infoEmpleado.put("estado_civil", responseInfoEmpleado.get("estado_civil"));
            infoEmpleado.put("tipo_empleado", responseInfoEmpleado.get("tipo_empleado"));

            return infoEmpleado;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}