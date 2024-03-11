package com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers;

import jakarta.persistence.*;

@Entity
@Table(name = "Datos_Empleado")
public class DatosEmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cod_emp")
    private String codEmp;
    private String dir_res;
    @Column(name = "celular")
    private String tel_celular;
    @Column(name = "pais_res")
    private String pais_residencia;
    @Column(name = "dpt_res")
    private String depto_res;
    @Column(name = "ciu_res")
    private String nom_ciu;
    private String e_mail_alt;
    private Integer est_civ_emp;
    private String ubicacion;
    private String usr_num_ext;
    private Integer ind_modifica;
    private Integer inf_veridica;
    private Integer ind_acepta;

    public DatosEmpleadoEntity() {
    }

    public DatosEmpleadoEntity(String cod_emp, String dir_res, String tel_celular, String pais_residencia, String depto_res, String nom_ciu, String e_mail_alt, Integer est_civ_emp, String ubicacion, String usr_num_ext, Integer ind_modifica, Integer inf_veridica, Integer ind_acepta) {
        this.codEmp = cod_emp;
        this.dir_res = dir_res;
        this.tel_celular = tel_celular;
        this.pais_residencia = pais_residencia;
        this.depto_res = depto_res;
        this.nom_ciu = nom_ciu;
        this.e_mail_alt = e_mail_alt;
        this.est_civ_emp = est_civ_emp;
        this.ubicacion = ubicacion;
        this.usr_num_ext = usr_num_ext;
        this.ind_modifica = ind_modifica;
        this.inf_veridica = inf_veridica;
        this.ind_acepta = ind_acepta;
    }

    public DatosEmpleadoEntity(String cod_emp, String dir_res, String tel_celular, String pais_residencia, String depto_res, String nom_ciu, String e_mail_alt, Integer est_civ_emp, String ubicacion, String usr_num_ext) {
        this.codEmp = cod_emp;
        this.dir_res = dir_res;
        this.tel_celular = tel_celular;
        this.pais_residencia = pais_residencia;
        this.depto_res = depto_res;
        this.nom_ciu = nom_ciu;
        this.e_mail_alt = e_mail_alt;
        this.est_civ_emp = est_civ_emp;
        this.ubicacion = ubicacion;
        this.usr_num_ext = usr_num_ext;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(String codEmp) {
        this.codEmp = codEmp;
    }

    public String getDir_res() {
        return dir_res;
    }

    public void setDir_res(String dir_res) {
        this.dir_res = dir_res;
    }

    public String getTel_celular() {
        return tel_celular;
    }

    public void setTel_celular(String tel_celular) {
        this.tel_celular = tel_celular;
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

    public String getE_mail_alt() {
        return e_mail_alt;
    }

    public void setE_mail_alt(String e_mail_alt) {
        this.e_mail_alt = e_mail_alt;
    }

    public Integer getEst_civ_emp() {
        return est_civ_emp;
    }

    public void setEst_civ_emp(Integer est_civ_emp) {
        this.est_civ_emp = est_civ_emp;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUsr_num_ext() {
        return usr_num_ext;
    }

    public void setUsr_num_ext(String usr_num_ext) {
        this.usr_num_ext = usr_num_ext;
    }

    public Integer getInd_modifica() {
        return ind_modifica;
    }

    public void setInd_modifica(Integer ind_modifica) {
        this.ind_modifica = ind_modifica;
    }

    public Integer getInf_veridica() {
        return inf_veridica;
    }

    public void setInf_veridica(Integer inf_veridica) {
        this.inf_veridica = inf_veridica;
    }

    public Integer getInd_acepta() {
        return ind_acepta;
    }

    public void setInd_acepta(Integer ind_acepta) {
        this.ind_acepta = ind_acepta;
    }
}
