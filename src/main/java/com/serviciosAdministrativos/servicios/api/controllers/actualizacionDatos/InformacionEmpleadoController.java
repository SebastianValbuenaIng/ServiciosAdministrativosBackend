package com.serviciosAdministrativos.servicios.api.controllers.actualizacionDatos;

import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizacionDatos.GTHInfoEmpleadoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/empleado")
public class InformacionEmpleadoController {
    private final GTHInfoEmpleadoRepository gthInformacionEmpleado;

    public InformacionEmpleadoController(GTHInfoEmpleadoRepository gthInformacionEmpleado) {
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

    @GetMapping("/redesSociales")
    public List<Map<String, Object>> getRedesSocialesByDocumentoEmpleado(@RequestParam String documento) {
        try {
            return gthInformacionEmpleado.findRedesSocialesByDocumento(documento);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/titulos")
    public List<Map<String, Object>> getTitulosByDocumentoEmpleado(@RequestParam String documento) {
        try {
            return gthInformacionEmpleado.findTitulosByDocumento(documento);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/detallesCargo")
    public ResponseEntity<Map<String, Object>> getDetallesDelCargoByDocumentoEmpleado(@RequestParam String documento) {
        try {
            Map<String, Object> responseInfoDetallesCargo = gthInformacionEmpleado.getDetallesCargoByDocumento(documento);

            Map<String, Object> infoDetallesCargo = new LinkedHashMap<>();

            infoDetallesCargo.put("cargo", responseInfoDetallesCargo.get("cargo") != null ? responseInfoDetallesCargo.get("cargo").toString().trim() : null);
            infoDetallesCargo.put("ubicacion_empleado", responseInfoDetallesCargo.get("ubicacion") != null ? responseInfoDetallesCargo.get("ubicacion").toString().trim() : null);
            infoDetallesCargo.put("extension", responseInfoDetallesCargo.get("extension") != null ? responseInfoDetallesCargo.get("extension").toString().trim() : null);
            infoDetallesCargo.put("area", responseInfoDetallesCargo.get("area") != null ? responseInfoDetallesCargo.get("area").toString().trim() : null);

            return ResponseEntity.ok(infoDetallesCargo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/experiencia")
    public ResponseEntity<List<Map<String, Object>>> getExperienciaByDocumentoEmpleado(@RequestParam String documento) {
        try {
            List<Map<String, Object>> resp = gthInformacionEmpleado.getExperienciaEmpleadoByDocumento(documento);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

            List<Map<String, Object>> respJson = resp.stream().map(stringObjectMap -> {
                Map<String, Object> expEmpl = new LinkedHashMap<>();
                expEmpl.put("nombre_empresa", stringObjectMap.get("nom_empr") != null ? stringObjectMap.get("nom_empr").toString().trim() : null);
                expEmpl.put("nombre_cargo", stringObjectMap.get("NOM_CAR") != null ? stringObjectMap.get("NOM_CAR").toString().trim() : null);
                expEmpl.put("area_experiencia", stringObjectMap.get("des_area_exp") != null ? stringObjectMap.get("des_area_exp").toString().trim() : null);
                expEmpl.put("funciones", stringObjectMap.get("des_fun") != null ? stringObjectMap.get("des_fun").toString().trim() : null);
                expEmpl.put("duracion_experiencia", stringObjectMap.get("duracion") != null ? stringObjectMap.get("duracion").toString().trim() : null);
                expEmpl.put("motivo_retiro", stringObjectMap.get("mot_ret") != null ? stringObjectMap.get("mot_ret").toString().trim() : null);
                expEmpl.put("nombre_jefe", stringObjectMap.get("jefe_inm") != null ? stringObjectMap.get("jefe_inm").toString().trim() : null);
                expEmpl.put("numero_jefe", stringObjectMap.get("num_tel") != null ? stringObjectMap.get("num_tel").toString().trim() : null);

                LocalDateTime dateTimeFechaIng = LocalDateTime.parse(stringObjectMap.get("fec_ing").toString(), formatter);
                String fechaIng = dateTimeFechaIng.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                expEmpl.put("fecha_ingreso", stringObjectMap.get("fec_ing") != null ? fechaIng : null);

                LocalDateTime dateTimeFechaTerm = LocalDateTime.parse(stringObjectMap.get("fec_ter").toString(), formatter);
                String fechaTerm = dateTimeFechaTerm.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                expEmpl.put("fecha_terminacion", stringObjectMap.get("fec_ter") != null ? fechaTerm : null);

                return expEmpl;
            }).toList();

            return ResponseEntity.ok(respJson);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/idiomas")
    public ResponseEntity<List<Map<String, Object>>> getIdiomasByDocumentoEmpleado(@RequestParam String documento) {
        try {
            List<Map<String, Object>> resp = gthInformacionEmpleado.getIdiomasEmpleadoByDocumento(documento);

            List<Map<String, Object>> respJson = resp.stream().map(stringObjectMap -> {
                Map<String, Object> idiomaEmpl = new LinkedHashMap<>();
                idiomaEmpl.put("idioma", stringObjectMap.get("nom_idi") != null ? stringObjectMap.get("nom_idi").toString().trim() : null);
                idiomaEmpl.put("nivel_idioma", stringObjectMap.get("Txt_Calif") != null ? stringObjectMap.get("Txt_Calif").toString().trim() : null);
                idiomaEmpl.put("nivel_habilidad", stringObjectMap.get("Des_habilidad") != null ? stringObjectMap.get("Des_habilidad").toString().trim() : null);
                return idiomaEmpl;
            }).toList();

            return ResponseEntity.ok(respJson);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/familiares")
    public ResponseEntity<List<Map<String, Object>>> getFamiliaresByDocumentoEmpleado(@RequestParam String documento) {
        try {
            List<Map<String, Object>> respFamiliares = gthInformacionEmpleado.getFamiliaresEmpleadoByDocumento(documento);

            List<Map<String, Object>> respJson = respFamiliares.stream().map(stringObjectMap -> {
                Map<String, Object> familiar = new LinkedHashMap<>();

                familiar.put("primer_apellido", stringObjectMap.get("primer_apell") != null ? stringObjectMap.get("primer_apell").toString().trim() : null);
                familiar.put("segundo_apellido", stringObjectMap.get("seg_apell") != null ? stringObjectMap.get("seg_apell").toString().trim() : null);
                familiar.put("nombres", stringObjectMap.get("nombres") != null ? stringObjectMap.get("nombres").toString().trim() : null);
                familiar.put("parentesco", stringObjectMap.get("nom_par") != null ? stringObjectMap.get("nom_par").toString().trim() : null);
                familiar.put("tipo_documento", stringObjectMap.get("tipo_doc") != null ? stringObjectMap.get("tipo_doc").toString().trim() : null);
                familiar.put("numero_documento", stringObjectMap.get("documento") != null ? stringObjectMap.get("documento").toString().trim() : null);
                familiar.put("fecha_nacimiento", stringObjectMap.get("fech_nac") != null ? stringObjectMap.get("fech_nac").toString().trim() : null);
                familiar.put("genero", stringObjectMap.get("des_gen") != null ? stringObjectMap.get("des_gen").toString().trim() : null);
                familiar.put("estado_civil", stringObjectMap.get("des_est") != null ? stringObjectMap.get("des_est").toString().trim() : null);
                familiar.put("ocupacion", stringObjectMap.get("des_ocu") != null ? stringObjectMap.get("des_ocu").toString().trim() : null);
                familiar.put("recibe_subsidio", stringObjectMap.get("recibe_sub") != null ? stringObjectMap.get("recibe_sub").toString().trim() : null);
                familiar.put("benificiario_pos", stringObjectMap.get("benef_pos") != null ? stringObjectMap.get("benef_pos").toString().trim() : null);
                familiar.put("convive_conmigo", stringObjectMap.get("convive_conmigo") != null ? stringObjectMap.get("convive_conmigo").toString().trim() : null);
                familiar.put("nivel_estudios", stringObjectMap.get("niv_estudio") != null ? stringObjectMap.get("niv_estudio").toString().trim() : null);
                familiar.put("termino_estudios", stringObjectMap.get("termino_estudios") != null ? stringObjectMap.get("termino_estudios").toString().trim() : null);

                return familiar;
            }).toList();

            return ResponseEntity.ok(respJson);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/areasInteres")
    public ResponseEntity<List<Map<String, Object>>> getAreasInteresByDocumentoEmpleado(@RequestParam String documento) {
        try {
            List<Map<String, Object>> respAreaInteres = gthInformacionEmpleado.getAreaInteresEmpleadoByDocumento(documento);

            List<Map<String, Object>> respJson = respAreaInteres.stream().map(stringObjectMap -> {
                Map<String, Object> areaInteres = new LinkedHashMap<>();

                areaInteres.put("descripcion", stringObjectMap.get("DESCRIPCION") != null ? stringObjectMap.get("DESCRIPCION").toString().trim() : null);
                areaInteres.put("cod_emp", stringObjectMap.get("cod_emp") != null ? stringObjectMap.get("cod_emp").toString().trim() : null);
                areaInteres.put("id_interes", stringObjectMap.get("id_interes"));

                return areaInteres;
            }).toList();

            return ResponseEntity.ok(respJson);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/perfil")
    public ResponseEntity<Map<String, Object>> getPerfilWebByDocumentoEmpleado(@RequestParam String documento) {
        try {
            Map<String, Object> respPerfilWeb = gthInformacionEmpleado.getPerfilWebEmpleadoByDocumento(documento);

            Map<String, Object> responseParrafos = new HashMap<>();

            if (!respPerfilWeb.isEmpty()) {
                String textoCompleto = respPerfilWeb.get("Perfil").toString();

                if (textoCompleto.trim().equals("No Aplica")) {
                    responseParrafos.put("parrafo1", "");
                    responseParrafos.put("parrafo2", "");
                    return ResponseEntity.ok(responseParrafos);
                }

                // Párrafo 1
                int indiceParrafo1p = textoCompleto.indexOf("Párrafo 1:");
                int indiceParrafo2p = textoCompleto.indexOf("Párrafo 2:");

                responseParrafos.put("parrafo1", textoCompleto.substring(indiceParrafo1p + 10, indiceParrafo2p).trim());

                // Párrafo 2
                int indiceParrafo1s = textoCompleto.indexOf("Párrafo 2:");

                responseParrafos.put("parrafo2", textoCompleto.substring(indiceParrafo1s + 10, textoCompleto.length() - 1).trim());

                return ResponseEntity.ok(responseParrafos);
            }

            responseParrafos.put("parrafo1", "");
            responseParrafos.put("parrafo2", "");
            return ResponseEntity.ok(responseParrafos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/publicaciones")
    public ResponseEntity<List<Map<String, String>>> getPublicacionesByDocumentoEmpleado(@RequestParam String documento) {
        try {
            List<Map<String, Object>> respPublicaciones = gthInformacionEmpleado.getPublicacionEmpleadoByDocumento(documento);

            List<Map<String, String>> returnPublic = respPublicaciones.stream().map(stringObjectMap -> {
                String publ = stringObjectMap.get("DESCRIP").toString();

                if (publ.contains("ISBN")) {
                    Map<String, String> publicExist = new HashMap<>();

                    // Cortar Titulo
                    String tituloSinEn = publ.trim().replaceAll("\"", "");
                    int indiceEn = tituloSinEn.indexOf("En:");
                    if (indiceEn >= 0) {
                        tituloSinEn = tituloSinEn.substring(0, indiceEn - 1);
                    }

                    String year_publicacion = publ.trim().substring(publ.indexOf("En: ") + 3, publ.indexOf("ed:") - 1).replaceAll("\\.", "").trim();
                    String editorial = publ.trim().substring(publ.indexOf("ed:") + 2, publ.indexOf("ISBN:") - 1).replaceAll(":", "").trim();
                    String isbn = publ.trim().substring(publ.indexOf("ISBN: ") + 5).trim();

                    publicExist.put("year_publicacion", year_publicacion);
                    publicExist.put("titulo", tituloSinEn);
                    publicExist.put("editorial", editorial);
                    publicExist.put("isbn", isbn);

                    return publicExist;
                }
                return Map.of("n", "");
            }).toList();

            if (respPublicaciones.isEmpty()) {
                return ResponseEntity.ok(List.of());
            } else if (returnPublic.get(1).containsKey("n") && returnPublic.get(1).get("n").isEmpty()) {
                return ResponseEntity.ok(List.of());
            }

            return ResponseEntity.ok(returnPublic);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}