package com.serviciosAdministrativos.servicios.api.controllers.actualizacionDatos;

import com.serviciosAdministrativos.servicios.domain.entities.DBActualizacionDatos.GTHEstadoCivilEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBActualizacionDatos.GTHGeneroEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBActualizacionDatos.GenClasif4Entity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizacionDatos.GTHGeneroRepository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizacionDatos.GTHInfoEmpleadoRepository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizacionDatos.GenClasif4Repository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizacionDatos.GenPaisesRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class ObtenerDatosGeneralesController {
    private final GTHGeneroRepository gthGeneroRepository;
    private final GTHInfoEmpleadoRepository gthInfoEmpleadoRepository;
    private final GenClasif4Repository genClasif4Repository;
    private final GenPaisesRepository genPaisesRepository;

    public ObtenerDatosGeneralesController(GTHGeneroRepository gthGeneroRepository,
                                           GTHInfoEmpleadoRepository gthInfoEmpleadoRepository,
                                           GenClasif4Repository genClasif4Repository,
                                           GenPaisesRepository genPaisesRepository) {
        this.gthGeneroRepository = gthGeneroRepository;
        this.gthInfoEmpleadoRepository = gthInfoEmpleadoRepository;
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
            return (List<GTHEstadoCivilEntity>) gthInfoEmpleadoRepository.findAll();
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
            List<Map<String, Object>> allCargos = gthInfoEmpleadoRepository.findAllCargos();

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
            List<Map<String, Object>> allTipoDocumento = gthInfoEmpleadoRepository.findAllTipoDocumento();

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

    @GetMapping("/parentesco")
    public List<Map<String, Object>> getParentesco() {
        try {
            List<Map<String, Object>> responseBD = gthInfoEmpleadoRepository.getParentesco();

            List<Map<String, Object>> response = new ArrayList<>();

            for (Map<String, Object> parentesco : responseBD) {
                Map<String, Object> parent = new HashMap<>();
                parent.put("cod_parentesco", parentesco.get("cod_par").toString().trim());
                parent.put("nombre_parentesco", parentesco.get("nom_par").toString().trim());
                response.add(parent);
            }

            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/ocupacion")
    public List<Map<String, Object>> getOcupacion() {
        try {
            List<Map<String, Object>> responseBD = gthInfoEmpleadoRepository.getOcupacion();

            List<Map<String, Object>> response = new ArrayList<>();

            for (Map<String, Object> parentesco : responseBD) {
                Map<String, Object> parent = new HashMap<>();
                parent.put("cod_ocupacion", parentesco.get("cod_ocu").toString().trim());
                parent.put("desc_ocupacion", parentesco.get("des_ocu").toString().trim());
                response.add(parent);
            }

            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/idiomas")
    public List<Map<String, Object>> getIdiomas() {
        try {
            List<Map<String, Object>> responseBD = gthInfoEmpleadoRepository.getIdiomas();

            List<Map<String, Object>> response = new ArrayList<>();

            for (Map<String, Object> parentesco : responseBD) {
                Map<String, Object> parent = new HashMap<>();
                parent.put("cod_idioma", parentesco.get("cod_idi").toString().trim());
                parent.put("nombre_idioma", parentesco.get("nom_idi").toString().trim());
                response.add(parent);
            }

            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/idiomaHabilidad")
    public List<Map<String, Object>> getHabilidadIdioma() {
        try {
            List<Map<String, Object>> responseBD = gthInfoEmpleadoRepository.getHabilidad();

            List<Map<String, Object>> response = new ArrayList<>();

            for (Map<String, Object> parentesco : responseBD) {
                Map<String, Object> parent = new HashMap<>();
                parent.put("cod_habilidad", parentesco.get("Cod_habilidad").toString().trim());
                parent.put("descripcion_habilidad", parentesco.get("Des_habilidad").toString().trim());
                response.add(parent);
            }

            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/calificacionIdioma")
    public List<Map<String, Object>> getCalificacionIdioma() {
        try {
            List<Map<String, Object>> responseBD = gthInfoEmpleadoRepository.getCalificacion();

            List<Map<String, Object>> response = new ArrayList<>();

            for (Map<String, Object> parentesco : responseBD) {
                Map<String, Object> parent = new HashMap<>();
                parent.put("cod_calificacion", parentesco.get("cod_calif").toString().trim());
                parent.put("calificacion", parentesco.get("Txt_Calif").toString().trim());
                parent.put("valor_calificacion", parentesco.get("val_calif").toString().trim());
                response.add(parent);
            }

            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/duracionExperiencia")
    public List<Map<String, Object>> getDuracionExperiencia() {
        try {
            List<Map<String, Object>> responseBD = gthInfoEmpleadoRepository.getDuracionExperiencia();

            List<Map<String, Object>> response = new ArrayList<>();

            for (Map<String, Object> parentesco : responseBD) {
                Map<String, Object> parent = new HashMap<>();
                parent.put("cod_duracion", parentesco.get("tpo_exp").toString().trim());
                parent.put("descripcion_duracion", parentesco.get("des_tpo_exp").toString().trim());
                response.add(parent);
            }

            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/areaExperiencia")
    public List<Map<String, Object>> getAreasExperiencia() {
        try {
            List<Map<String, Object>> responseBD = gthInfoEmpleadoRepository.getAreasExperiencia();

            List<Map<String, Object>> response = new ArrayList<>();

            for (Map<String, Object> parentesco : responseBD) {
                Map<String, Object> parent = new HashMap<>();
                parent.put("area_exp", parentesco.get("area_exp").toString().trim());
                parent.put("des_area_exp", parentesco.get("des_area_exp").toString().trim());
                response.add(parent);
            }

            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/nivelEstudios")
    public List<Map<String, Object>> getNivelEstudios() {
        try {
            List<Map<String, Object>> responseBD = gthInfoEmpleadoRepository.getNivelEstudios();

            List<Map<String, Object>> response = new ArrayList<>();

            for (Map<String, Object> parentesco : responseBD) {
                Map<String, Object> parent = new HashMap<>();
                parent.put("tip_est", parentesco.get("tip_est").toString().trim());
                parent.put("des_est", parentesco.get("des_est").toString().trim());
                response.add(parent);
            }

            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/estudios")
    public List<Map<String, Object>> getEstudios() {
        try {
            List<Map<String, Object>> responseBD = gthInfoEmpleadoRepository.getEstudios();

            List<Map<String, Object>> response = new ArrayList<>();

            for (Map<String, Object> parentesco : responseBD) {
                Map<String, Object> parent = new HashMap<>();
                parent.put("cod_est", parentesco.get("cod_est").toString().trim());
                parent.put("nom_est", parentesco.get("nom_est").toString().trim());
                response.add(parent);
            }

            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/instituciones")
    public List<Map<String, Object>> getInstituciones() {
        try {
            List<Map<String, Object>> responseBD = gthInfoEmpleadoRepository.getInstituciones();

            List<Map<String, Object>> response = new ArrayList<>();

            for (Map<String, Object> parentesco : responseBD) {
                Map<String, Object> parent = new HashMap<>();
                parent.put("cod_ins", parentesco.get("cod_ins").toString().trim());
                parent.put("nom_ins", parentesco.get("nom_ins").toString().trim());
                response.add(parent);
            }

            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}