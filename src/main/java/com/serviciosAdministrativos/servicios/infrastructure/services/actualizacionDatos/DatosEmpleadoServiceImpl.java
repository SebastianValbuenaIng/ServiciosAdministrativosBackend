package com.serviciosAdministrativos.servicios.infrastructure.services.actualizacionDatos;

import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request.InformacionEmpleadoRequest;
import com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.response.DatosEmpleadoRedesSocialesResponse;
import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.DatosEmpleadoEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.FechasEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers.RedesSocialesEntity;
import com.serviciosAdministrativos.servicios.domain.entities.DBActualizacionDatos.UsrRhhActualizaDatosEntity;
import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers.DatosEmpleadoRepository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers.FechasRepository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers.RedesSocialesRepository;
import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizacionDatos.UsrRhhActualizaDatosRepository;
import com.serviciosAdministrativos.servicios.infrastructure.abstract_services.actualizacionDatos.DatosEmpleadoService;
import com.serviciosAdministrativos.servicios.util.errors.NotFoundError;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class DatosEmpleadoServiceImpl implements DatosEmpleadoService {
    private final DatosEmpleadoRepository datosEmpleadoRepository;
    private final RedesSocialesRepository redesSocialesRepository;
    private final UsrRhhActualizaDatosRepository usrRhhActualizaDatosRepository;
    private final FechasRepository fechasRepository;

    public DatosEmpleadoServiceImpl(DatosEmpleadoRepository datosEmpleadoRepository,
                                    RedesSocialesRepository redesSocialesRepository,
                                    UsrRhhActualizaDatosRepository usrRhhActualizaDatosRepository,
                                    FechasRepository fechasRepository) {
        this.datosEmpleadoRepository = datosEmpleadoRepository;
        this.redesSocialesRepository = redesSocialesRepository;
        this.usrRhhActualizaDatosRepository = usrRhhActualizaDatosRepository;
        this.fechasRepository = fechasRepository;
    }

    @Override
    public DatosEmpleadoRedesSocialesResponse findDatosEmpleadoByCoEmp(String documento) {
        Optional<DatosEmpleadoEntity> findDatosEmpleado = datosEmpleadoRepository.findByCodEmp(documento);

        if (findDatosEmpleado.isEmpty()) throw new NotFoundError("El empleado no existe");

        List<RedesSocialesEntity> findRedesSocialesByEmpleado = redesSocialesRepository.findAllByCodEmp(documento);

        return entityToResponse(findDatosEmpleado.get(), findRedesSocialesByEmpleado);
    }

    private DatosEmpleadoRedesSocialesResponse entityToResponse(DatosEmpleadoEntity datosEmpleadoEntity,
                                                                List<RedesSocialesEntity> redesSocialesByEmpleado) {

        List<Map<String, Object>> redes_sociales = redesSocialesByEmpleado.stream().map(redesSocialesEntity -> {
            Map<String, Object> red_social = new LinkedHashMap<>();
            red_social.put("cod_red_soc", redesSocialesEntity.getCodRedsoc());
            red_social.put("usuario_red", redesSocialesEntity.getUsuario_red());

            return red_social;
        }).toList();

        return new DatosEmpleadoRedesSocialesResponse(
                datosEmpleadoEntity.getPais_residencia(),
                datosEmpleadoEntity.getDepto_res(),
                datosEmpleadoEntity.getNom_ciu(),
                datosEmpleadoEntity.getTel_celular(),
                datosEmpleadoEntity.getE_mail_alt(),
                datosEmpleadoEntity.getUsr_num_ext(),
                datosEmpleadoEntity.getUbicacion(),
                datosEmpleadoEntity.getEst_civ_emp(),
                datosEmpleadoEntity.getDir_res(),
                redes_sociales
        );
    }

    @Override
    public DatosEmpleadoEntity newDatosEmpleadoToSave(String documento, InformacionEmpleadoRequest informacionEmpleadoRequest) {
        Optional<DatosEmpleadoEntity> findDatosEmpleado = datosEmpleadoRepository.findByCodEmp(documento);

        if (findDatosEmpleado.isPresent()) {
            findDatosEmpleado.get().setDir_res(informacionEmpleadoRequest.getDireccion_residencia());
            findDatosEmpleado.get().setTel_celular(informacionEmpleadoRequest.getTel_celular().toString());
            findDatosEmpleado.get().setPais_residencia(informacionEmpleadoRequest.getCod_pais());
            findDatosEmpleado.get().setDepto_res(informacionEmpleadoRequest.getCod_departamento());
            findDatosEmpleado.get().setNom_ciu(informacionEmpleadoRequest.getCod_ciudad());
            findDatosEmpleado.get().setE_mail_alt(informacionEmpleadoRequest.getEmail_alterno());
            findDatosEmpleado.get().setEst_civ_emp(informacionEmpleadoRequest.getCod_estado_civil());
            findDatosEmpleado.get().setUbicacion(informacionEmpleadoRequest.getUbicacion());
            findDatosEmpleado.get().setUsr_num_ext(informacionEmpleadoRequest.getUsr_num_ext());
            findDatosEmpleado.get().setInf_veridica(informacionEmpleadoRequest.getConfirmarVericidad());
            findDatosEmpleado.get().setInd_acepta(informacionEmpleadoRequest.getAceptarTratamiento());
            findDatosEmpleado.get().setInd_modifica(informacionEmpleadoRequest.getAdicionoEstudios());

            datosEmpleadoRepository.save(findDatosEmpleado.get());

            if (!informacionEmpleadoRequest.getRed_social().isEmpty()) {

                informacionEmpleadoRequest.getRed_social().forEach(stringObjectMap -> {
                    Optional<RedesSocialesEntity> findByCodRedSoc = redesSocialesRepository
                            .findByCodRedsocAndCodEmp((Integer) stringObjectMap.get("cod_red_soc"), documento);

                    if (findByCodRedSoc.isPresent()) {
                        if (!stringObjectMap.get("usuario_red").toString().trim().isEmpty()) {
                            findByCodRedSoc.get().setUsuario_red(stringObjectMap.get("usuario_red").toString());
                            redesSocialesRepository.save(findByCodRedSoc.get());
                        }
                    } else {
                        if (!stringObjectMap.get("usuario_red").toString().trim().isEmpty()) {
                            RedesSocialesEntity redesSocialesEntity = new RedesSocialesEntity(
                                    documento,
                                    (Integer) stringObjectMap.get("cod_red_soc"),
                                    stringObjectMap.get("usuario_red").toString()
                            );

                            redesSocialesRepository.save(redesSocialesEntity);
                        }
                    }
                });
            }

            return findDatosEmpleado.get();
        }

        DatosEmpleadoEntity datosEmpleadoEntityToSave = new DatosEmpleadoEntity(
                documento,
                informacionEmpleadoRequest.getDireccion_residencia(),
                informacionEmpleadoRequest.getTel_celular().toString(),
                informacionEmpleadoRequest.getCod_pais(),
                informacionEmpleadoRequest.getCod_departamento(),
                informacionEmpleadoRequest.getCod_ciudad(),
                informacionEmpleadoRequest.getEmail_alterno(),
                informacionEmpleadoRequest.getCod_estado_civil(),
                informacionEmpleadoRequest.getUbicacion(),
                informacionEmpleadoRequest.getUsr_num_ext(),
                informacionEmpleadoRequest.getConfirmarVericidad(),
                informacionEmpleadoRequest.getAceptarTratamiento(),
                informacionEmpleadoRequest.getAdicionoEstudios()
        );

        DatosEmpleadoEntity datosEmpleadoSaved = datosEmpleadoRepository.save(datosEmpleadoEntityToSave);

        if (!informacionEmpleadoRequest.getRed_social().isEmpty()) {
            informacionEmpleadoRequest.getRed_social().forEach(stringObjectMap -> {
                if (!stringObjectMap.get("usuario_red").toString().trim().isEmpty()) {
                    RedesSocialesEntity redesSocialesEntity = new RedesSocialesEntity(
                            documento,
                            (Integer) stringObjectMap.get("cod_red_soc"),
                            stringObjectMap.get("usuario_red").toString()
                    );

                    redesSocialesRepository.save(redesSocialesEntity);
                }
            });
        }

        return datosEmpleadoSaved;
    }

    @Override
    @Scheduled(cron = "0 0 0 * * *")
//    @Scheduled(cron = "30 * * * * *")
    public void insertActualizaDatos() {
        Optional<FechasEntity> firstFecha = fechasRepository.findFirstFecha();

        if (firstFecha.isEmpty()) throw new RuntimeException("No existe una fecha final para la actualizacion de datos");

        if (LocalDateTime.now().isBefore(firstFecha.get().getFecha_fin()) && LocalDateTime.now().isAfter(firstFecha.get().getFecha_ini())) {
            List<Map<String, Object>> allDatosEmpleado = datosEmpleadoRepository.selectAllTablesActualizaDatosPers();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

            allDatosEmpleado.forEach(stringObjectMap -> {
                UsrRhhActualizaDatosEntity usrRhhActualizaDatosToSave = new UsrRhhActualizaDatosEntity();
                usrRhhActualizaDatosToSave.setCod_emp(stringObjectMap.get("cod_emp") != null ? stringObjectMap.get("cod_emp").toString() : null);
                usrRhhActualizaDatosToSave.setDir_res(stringObjectMap.get("dir_res") != null ? stringObjectMap.get("dir_res").toString() : null);

                int resultRedSocial = Integer.parseInt(stringObjectMap.get("cod_redsoc") != null ? stringObjectMap.get("cod_redsoc").toString() : "999");
                usrRhhActualizaDatosToSave.setCod_redsoc(resultRedSocial != 999 ? resultRedSocial : null);

                usrRhhActualizaDatosToSave.setUsuario_red(stringObjectMap.get("usuario_red") != null ? stringObjectMap.get("usuario_red").toString() : null);

                String resultPublicacion = stringObjectMap.get("titulo_public") != null ? stringObjectMap.get("titulo_public").toString() + " En: " + LocalDate.parse(stringObjectMap.get("fecha_public").toString()).getYear() + " ed: " + stringObjectMap.get("editorial").toString() + " ISBN: " + stringObjectMap.get("isbn") : null;

                usrRhhActualizaDatosToSave.setDescrip_publicacion(resultPublicacion);

                usrRhhActualizaDatosToSave.setUbicacion(stringObjectMap.get("ubicacion") != null ? stringObjectMap.get("ubicacion").toString().trim().isEmpty() ?
                        null : stringObjectMap.get("ubicacion").toString() : null);

                usrRhhActualizaDatosToSave.setUsr_num_ext(stringObjectMap.get("usr_num_ext") != null ?
                        Integer.parseInt(stringObjectMap.get("usr_num_ext").toString().trim()) != 0 ? stringObjectMap.get("usr_num_ext").toString() : null : null);

                usrRhhActualizaDatosToSave.setId_interes(stringObjectMap.get("cod_area") != null ? Integer.parseInt(stringObjectMap.get("cod_area").toString()) : null);
                usrRhhActualizaDatosToSave.setNom_empr(stringObjectMap.get("nom_empr") != null ? stringObjectMap.get("nom_empr").toString() : null);
                usrRhhActualizaDatosToSave.setNom_car(stringObjectMap.get("nom_car") != null ? stringObjectMap.get("nom_car").toString() : null);
                usrRhhActualizaDatosToSave.setArea_exp(stringObjectMap.get("area_exp") != null ? Integer.parseInt(stringObjectMap.get("area_exp").toString()) : null);
                usrRhhActualizaDatosToSave.setDes_fun(stringObjectMap.get("des_fun") != null ? stringObjectMap.get("des_fun").toString() : null);
                usrRhhActualizaDatosToSave.setTpo_exp(stringObjectMap.get("tpo_exp") != null ? Integer.parseInt(stringObjectMap.get("tpo_exp").toString()) : null);
                usrRhhActualizaDatosToSave.setMot_ret(stringObjectMap.get("mot_ret") != null ? stringObjectMap.get("mot_ret").toString() : null);
                usrRhhActualizaDatosToSave.setJefe_inm(stringObjectMap.get("jefe_inm") != null ? stringObjectMap.get("jefe_inm").toString() : null);
                usrRhhActualizaDatosToSave.setNum_tel(stringObjectMap.get("num_tel") != null ? stringObjectMap.get("num_tel").toString() : null);

                if (stringObjectMap.get("fec_ing") != null) {
                    LocalDateTime fechaHora = LocalDateTime.parse(stringObjectMap.get("fec_ing").toString(), formatter);
                    usrRhhActualizaDatosToSave.setFec_ing(stringObjectMap.get("fec_ing") != null ? fechaHora : null);
                } else {
                    usrRhhActualizaDatosToSave.setFec_ing(null);
                }

                LocalDateTime fechaTer = LocalDateTime.parse(stringObjectMap.get("fec_ter").toString(), formatter);
                usrRhhActualizaDatosToSave.setFec_ter(stringObjectMap.get("fec_ter") != null ? fechaTer : null);

                usrRhhActualizaDatosToSave.setPai_res(stringObjectMap.get("pais_res") != null ? stringObjectMap.get("pais_res").toString() : null);
                usrRhhActualizaDatosToSave.setDpt_res(stringObjectMap.get("dpt_res") != null ? stringObjectMap.get("dpt_res").toString() : null);
                usrRhhActualizaDatosToSave.setCiu_res(stringObjectMap.get("ciu_res") != null ? stringObjectMap.get("ciu_res").toString() : null);
                usrRhhActualizaDatosToSave.setE_mail_alt(stringObjectMap.get("e_mail_alt") != null ? stringObjectMap.get("e_mail_alt").toString() : null);
                usrRhhActualizaDatosToSave.setCelular(stringObjectMap.get("celular") != null ? stringObjectMap.get("celular").toString() : null);
                usrRhhActualizaDatosToSave.setCod_estudio(stringObjectMap.get("cod_estudio") != null ? stringObjectMap.get("cod_estudio").toString() : null);
                usrRhhActualizaDatosToSave.setCod_ins(stringObjectMap.get("cod_ins") != null ? stringObjectMap.get("cod_ins").toString() : null);
                usrRhhActualizaDatosToSave.setAno_est(stringObjectMap.get("ano_est") != null ? Integer.parseInt(stringObjectMap.get("ano_est").toString()) : null);

                LocalDateTime fechaGra = LocalDateTime.parse(stringObjectMap.get("fec_gra").toString(), formatter);
                usrRhhActualizaDatosToSave.setFec_gra(stringObjectMap.get("fec_gra") != null ? fechaGra : null);

                usrRhhActualizaDatosToSave.setNro_tar(stringObjectMap.get("nro_tar") != null ? stringObjectMap.get("nro_tar").toString() : null);
                usrRhhActualizaDatosToSave.setCod_idi(stringObjectMap.get("cod_idi") != null ? stringObjectMap.get("cod_idi").toString() : null);
                usrRhhActualizaDatosToSave.setCod_calif(stringObjectMap.get("cod_calif") != null ? stringObjectMap.get("cod_calif").toString() : null);
                usrRhhActualizaDatosToSave.setCod_hab(stringObjectMap.get("cod_hab") != null ? stringObjectMap.get("cod_hab").toString() : null);
                usrRhhActualizaDatosToSave.setAp1_fam(stringObjectMap.get("ap1_fam") != null ? stringObjectMap.get("ap1_fam").toString() : null);

                usrRhhActualizaDatosToSave.setAp2_fam(stringObjectMap.get("ap2_fam") != null ? stringObjectMap.get("ap2_fam").toString().trim().isEmpty()
                        ? stringObjectMap.get("ap2_fam").toString() : null : null);

                usrRhhActualizaDatosToSave.setNom_fam(stringObjectMap.get("nom_fam") != null ? stringObjectMap.get("nom_fam").toString() : null);
                usrRhhActualizaDatosToSave.setTip_fam(stringObjectMap.get("tip_fam") != null ? stringObjectMap.get("tip_fam").toString() : null);
                usrRhhActualizaDatosToSave.setTip_ide(stringObjectMap.get("tip_ide") != null ? stringObjectMap.get("tip_ide").toString() : null);
                usrRhhActualizaDatosToSave.setNum_ced(stringObjectMap.get("num_ced") != null ? stringObjectMap.get("num_ced").toString() : null);

                LocalDateTime fecNac = LocalDateTime.parse(stringObjectMap.get("fec_nac").toString(), formatter);
                usrRhhActualizaDatosToSave.setFec_nac(stringObjectMap.get("fec_nac") != null ? fecNac : null);

                usrRhhActualizaDatosToSave.setSex_fam(stringObjectMap.get("sex_fam") != null ? Integer.parseInt(stringObjectMap.get("sex_fam").toString()) : null);
                usrRhhActualizaDatosToSave.setEst_civ_fam(stringObjectMap.get("est_civ_fam") != null ? Integer.parseInt(stringObjectMap.get("est_civ_fam").toString()) : null);
                usrRhhActualizaDatosToSave.setNiv_est(stringObjectMap.get("niv_est") != null ? stringObjectMap.get("niv_est").toString() : null);
                usrRhhActualizaDatosToSave.setOcu_fam(stringObjectMap.get("ocu_fam") != null ? Integer.parseInt(stringObjectMap.get("ocu_fam").toString()) : null);
                usrRhhActualizaDatosToSave.setEst_civ_emp(stringObjectMap.get("est_civ_emp") != null ? Integer.parseInt(stringObjectMap.get("est_civ_emp").toString()) : null);

                usrRhhActualizaDatosToSave.setInd_comp(stringObjectMap.get("ind_comp") != null ? stringObjectMap.get("ind_comp").toString().equals("true") ? 1 : 0 : null);

                usrRhhActualizaDatosToSave.setInd_sub(stringObjectMap.get("ind_sub") != null ? stringObjectMap.get("ind_sub").toString().equals("true") ? 1 : 0 : null);
                usrRhhActualizaDatosToSave.setInd_pro(stringObjectMap.get("ind_pro") != null ? stringObjectMap.get("ind_pro").toString().equals("true") ? 1 : 0 : null);
                usrRhhActualizaDatosToSave.setInd_conv(stringObjectMap.get("ind_conv") != null ? stringObjectMap.get("ind_conv").toString().equals("true") ? 1 : 0 : null);
                usrRhhActualizaDatosToSave.setInd_conv(stringObjectMap.get("ind_conv") != null ? stringObjectMap.get("ind_conv").toString().equals("true") ? 1 : 0 : null);
                usrRhhActualizaDatosToSave.setInd_modifica(stringObjectMap.get("ind_modifica") != null ? stringObjectMap.get("ind_modifica").toString().equals("true") ? 1 : 0 : null);
                usrRhhActualizaDatosToSave.setInf_veridica(stringObjectMap.get("inf_veridica") != null ? stringObjectMap.get("inf_veridica").toString().equals("true") ? 1 : 0 : null);
                usrRhhActualizaDatosToSave.setInd_acepta(stringObjectMap.get("ind_acepta") != null ? stringObjectMap.get("ind_acepta").toString().equals("true") ? 1 : 0 : null);

                usrRhhActualizaDatosToSave.setFec_registro(LocalDateTime.now());

                usrRhhActualizaDatosToSave.setPerfil(
                        "Párrafo 1: " + (stringObjectMap.get("parrafo1") != null ? stringObjectMap.get("parrafo1").toString() : "") + "\\n"
                        + "Párrafo 2: " + (stringObjectMap.get("parrafo2") != null ? stringObjectMap.get("parrafo2").toString() : "") + "\\n"
                        + "DISTINCIONES: " + (stringObjectMap.get("reconocimientos") != null ? stringObjectMap.get("reconocimientos").toString() : "") + "\\n"
                        + "Membresias: " + (stringObjectMap.get("membresias") != null ? stringObjectMap.get("membresias").toString() : "") + "\\n"
                        + "Cargos: " + (stringObjectMap.get("cargo_direc") != null ? stringObjectMap.get("cargo_direc").toString() : "")
                );

                usrRhhActualizaDatosRepository.save(usrRhhActualizaDatosToSave);
            });
        }
    }
}
