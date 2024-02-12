package com.serviciosAdministrativos.servicios.api.controllers.actualizacionDatos;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizacionDatos.*;
import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizacionDatos.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class ObtenerDatosGeneralesController {
    private final GTHGeneroRepository gthGeneroRepository;
    private final GTHEstadoCivilRepository gthEstadoCivilRepository;
    private final GenClasif4Repository genClasif4Repository;
    private final GenPaisesRepository genPaisesRepository;

    public ObtenerDatosGeneralesController(GTHGeneroRepository gthGeneroRepository,
                                           GTHEstadoCivilRepository gthEstadoCivilRepository,
                                           GenClasif4Repository genClasif4Repository,
                                           GenPaisesRepository genPaisesRepository) {
        this.gthGeneroRepository = gthGeneroRepository;
        this.gthEstadoCivilRepository = gthEstadoCivilRepository;
        this.genClasif4Repository = genClasif4Repository;
        this.genPaisesRepository = genPaisesRepository;
    }

    @GetMapping("/generos")
    public List<GTHGeneroEntity> getGeneros() {
        try {
            return (List<GTHGeneroEntity>) gthGeneroRepository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/estadoCivil")
    public List<GTHEstadoCivilEntity> getEstadoCivil() {
        try {
            return (List<GTHEstadoCivilEntity>) gthEstadoCivilRepository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/tipoEmpleado")
    public List<GenClasif4Entity> getTipoEmpleado() {
        try {
            return genClasif4Repository.findAllByEstado("1");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/paises")
    public List<Map<String, Object>> getPaises() {
        try {
            List<Map<String, Object>> allDeptos = genPaisesRepository.findAllPaises();

            List<Map<String, Object>> response = new ArrayList<>();

            for (Map<String, Object> allDepto : allDeptos) {
                Map<String, Object> depto = new HashMap<>();
                depto.put("cod_pai", allDepto.get("cod_pai"));
                depto.put("nom_pai", allDepto.get("nom_pai").toString().trim());
                response.add(depto);
            }

            return response
                    .stream()
                    .sorted(Comparator.comparing(o -> o.get("nom_pai").toString()))
                    .toList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/departamentos")
    public List<Map<String, Object>> getDepartamentos() {
        try {
            List<Map<String, Object>> allDeptos = genPaisesRepository.findAllDeptos();

            List<Map<String, Object>> response = new ArrayList<>();

            for (Map<String, Object> allDepto : allDeptos) {
                Map<String, Object> depto = new HashMap<>();
                depto.put("cod_pai", allDepto.get("cod_pai"));
                depto.put("cod_dep", allDepto.get("cod_dep"));
                depto.put("nom_dep", allDepto.get("nom_dep").toString().trim());
                response.add(depto);
            }

            return response
                    .stream()
                    .sorted(Comparator.comparing(o -> o.get("nom_dep").toString()))
                    .toList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/ciudades")
    public List<Map<String, Object>> getCiudades() {
        try {
            List<Map<String, Object>> allCiudades = genPaisesRepository.findAllCiudades();

            List<Map<String, Object>> response = new ArrayList<>();

            for (Map<String, Object> allCities : allCiudades) {
                Map<String, Object> depto = new HashMap<>();
                depto.put("cod_pai", allCities.get("cod_pai"));
                depto.put("cod_dep", allCities.get("cod_dep"));
                depto.put("cod_ciu", allCities.get("cod_ciu"));
                depto.put("nom_dep", allCities.get("nom_ciu").toString().trim());
                response.add(depto);
            }

            return response;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/cargos")
    public List<Map<String, Object>> getCargos() {
        try {
            List<Map<String, Object>> allCargos = gthEstadoCivilRepository.findAllCargos();

            List<Map<String, Object>> response = new ArrayList<>();

            for (Map<String, Object> cargo : allCargos) {
                Map<String, Object> depto = new HashMap<>();
                depto.put("cod_car", cargo.get("cod_car").toString().trim());
                depto.put("nom_car", cargo.get("nom_car").toString().trim());
                response.add(depto);
            }

            return response;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/tipoDocumento")
    public List<Map<String, Object>> getTipoDocumento() {
        try {
            List<Map<String, Object>> allTipoDocumento = gthEstadoCivilRepository.findAllTipoDocumento();

            List<Map<String, Object>> response = new ArrayList<>();

            for (Map<String, Object> tipoDocumento : allTipoDocumento) {
                Map<String, Object> depto = new HashMap<>();
                depto.put("cod_tip", tipoDocumento.get("cod_tip").toString().trim());
                depto.put("des_tip", tipoDocumento.get("des_tip").toString().trim());
                depto.put("tip_tip", tipoDocumento.get("tip_tip"));
                depto.put("cod_dian", tipoDocumento.get("cod_dian"));
                response.add(depto);
            }

            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}