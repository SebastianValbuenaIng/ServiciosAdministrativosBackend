package com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.response;

import java.util.List;
import java.util.Map;

public class DatosEmpleadoRedesSocialesResponse {
    private String pais_residencia;
    private String depto_res;
    private String nom_ciu;
    private String tel_celular;
    private String e_mail_alt;
    private String usr_num_ext;
    private String ubicacion;
    private Integer est_civ_emp;
    private String dirRes;
    private List<Map<String, Object>> redes_sociales;

    public DatosEmpleadoRedesSocialesResponse() {
    }

    public DatosEmpleadoRedesSocialesResponse(String pais_residencia, String depto_res, String nom_ciu, String tel_celular, String e_mail_alt, String usr_num_ext, String ubicacion, Integer est_civ_emp, String dirRes, List<Map<String, Object>> redes_sociales) {
        this.pais_residencia = pais_residencia;
        this.depto_res = depto_res;
        this.nom_ciu = nom_ciu;
        this.tel_celular = tel_celular;
        this.e_mail_alt = e_mail_alt;
        this.usr_num_ext = usr_num_ext;
        this.ubicacion = ubicacion;
        this.est_civ_emp = est_civ_emp;
        this.dirRes = dirRes;
        this.redes_sociales = redes_sociales;
    }

    public String getPais_residencia() {
        return pais_residencia;
    }

    public void setPais_residencia(String pais_residencia) {
        this.pais_residencia = pais_residencia;
    }

    public String getDepto_res() {
        return depto_res;
    }

    public void setDepto_res(String depto_res) {
        this.depto_res = depto_res;
    }

    public String getNom_ciu() {
        return nom_ciu;
    }

    public void setNom_ciu(String nom_ciu) {
        this.nom_ciu = nom_ciu;
    }

    public String getTel_celular() {
        return tel_celular;
    }

    public void setTel_celular(String tel_celular) {
        this.tel_celular = tel_celular;
    }

    public String getE_mail_alt() {
        return e_mail_alt;
    }

    public void setE_mail_alt(String e_mail_alt) {
        this.e_mail_alt = e_mail_alt;
    }

    public String getUsr_num_ext() {
        return usr_num_ext;
    }

    public void setUsr_num_ext(String usr_num_ext) {
        this.usr_num_ext = usr_num_ext;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getEst_civ_emp() {
        return est_civ_emp;
    }

    public void setEst_civ_emp(Integer est_civ_emp) {
        this.est_civ_emp = est_civ_emp;
    }

    public String getDirRes() {
        return dirRes;
    }

    public void setDirRes(String dirRes) {
        this.dirRes = dirRes;
    }

    public List<Map<String, Object>> getRedes_sociales() {
        return redes_sociales;
    }

    public void setRedes_sociales(List<Map<String, Object>> redes_sociales) {
        this.redes_sociales = redes_sociales;
    }
}
