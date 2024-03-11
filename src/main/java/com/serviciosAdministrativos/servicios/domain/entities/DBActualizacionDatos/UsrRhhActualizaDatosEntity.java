package com.serviciosAdministrativos.servicios.domain.entities.DBActualizacionDatos;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "USR_RHH_ACTUALIZA_DATOS")
public class UsrRhhActualizaDatosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registro;
    private String cod_emp;
    private String dir_res;
    private Integer cod_redsoc;
    private String usuario_red;
    private String descrip_publicacion;
    private String usu_inserta;
    private String ubicacion;
    private String usr_num_ext;
    private Integer id_interes;
    private String nom_empr;
    private String nom_car;
    private Integer area_exp;
    private String des_fun;
    private Integer tpo_exp;
    private String mot_ret;
    private String jefe_inm;
    private String num_tel;
    private LocalDateTime fec_ing;
    private LocalDateTime fec_ter;
    private String pai_res;
    private String dpt_res;
    private String ciu_res;
    private String e_mail_alt;
    private String perfil;
    private String celular;
    private String cod_estudio;
    private String cod_ins;
    private Integer ano_est;
    private Integer graduado;
    private LocalDateTime fec_gra;
    private String nro_tar;
    private Integer ind_can;
    private String tipo_est;
    private String cod_idi;
    private String cod_calif;
    private String cod_hab;
    private String ap1_fam;
    private String ap2_fam;
    private String nom_fam;
    private String tip_fam;
    private String tip_ide;
    private String num_ced;
    private LocalDateTime fec_nac;
    private Integer sex_fam;
    private Integer est_civ_fam;
    private String niv_est;
    private Integer ind_comp;
    private Integer ocu_fam;
    private Integer ind_sub;
    private Integer ind_pro;
    private Integer ind_conv;
    private Integer ind_modifica;
    private Integer inf_veridica;
    private Integer ind_acepta;
    private Integer est_civ_emp;
    private LocalDateTime fec_registro;

    public UsrRhhActualizaDatosEntity() {
    }

    public Integer getRegistro() {
        return registro;
    }

    public void setRegistro(Integer registro) {
        this.registro = registro;
    }

    public String getCod_emp() {
        return cod_emp;
    }

    public void setCod_emp(String cod_emp) {
        this.cod_emp = cod_emp;
    }

    public String getDir_res() {
        return dir_res;
    }

    public void setDir_res(String dir_res) {
        this.dir_res = dir_res;
    }

    public Integer getCod_redsoc() {
        return cod_redsoc;
    }

    public void setCod_redsoc(Integer cod_redsoc) {
        this.cod_redsoc = cod_redsoc;
    }

    public String getUsuario_red() {
        return usuario_red;
    }

    public void setUsuario_red(String usuario_red) {
        this.usuario_red = usuario_red;
    }

    public String getDescrip_publicacion() {
        return descrip_publicacion;
    }

    public void setDescrip_publicacion(String descrip_publicacion) {
        this.descrip_publicacion = descrip_publicacion;
    }

    public String getUsu_inserta() {
        return usu_inserta;
    }

    public void setUsu_inserta(String usu_inserta) {
        this.usu_inserta = usu_inserta;
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

    public Integer getId_interes() {
        return id_interes;
    }

    public void setId_interes(Integer id_interes) {
        this.id_interes = id_interes;
    }

    public String getNom_empr() {
        return nom_empr;
    }

    public void setNom_empr(String nom_empr) {
        this.nom_empr = nom_empr;
    }

    public String getNom_car() {
        return nom_car;
    }

    public void setNom_car(String nom_car) {
        this.nom_car = nom_car;
    }

    public Integer getArea_exp() {
        return area_exp;
    }

    public void setArea_exp(Integer area_exp) {
        this.area_exp = area_exp;
    }

    public String getDes_fun() {
        return des_fun;
    }

    public void setDes_fun(String des_fun) {
        this.des_fun = des_fun;
    }

    public Integer getTpo_exp() {
        return tpo_exp;
    }

    public void setTpo_exp(Integer tpo_exp) {
        this.tpo_exp = tpo_exp;
    }

    public String getMot_ret() {
        return mot_ret;
    }

    public void setMot_ret(String mot_ret) {
        this.mot_ret = mot_ret;
    }

    public String getJefe_inm() {
        return jefe_inm;
    }

    public void setJefe_inm(String jefe_inm) {
        this.jefe_inm = jefe_inm;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

    public LocalDateTime getFec_ing() {
        return fec_ing;
    }

    public void setFec_ing(LocalDateTime fec_ing) {
        this.fec_ing = fec_ing;
    }

    public LocalDateTime getFec_ter() {
        return fec_ter;
    }

    public void setFec_ter(LocalDateTime fec_ter) {
        this.fec_ter = fec_ter;
    }

    public String getPai_res() {
        return pai_res;
    }

    public void setPai_res(String pai_res) {
        this.pai_res = pai_res;
    }

    public String getDpt_res() {
        return dpt_res;
    }

    public void setDpt_res(String dpt_res) {
        this.dpt_res = dpt_res;
    }

    public String getCiu_res() {
        return ciu_res;
    }

    public void setCiu_res(String ciu_res) {
        this.ciu_res = ciu_res;
    }

    public String getE_mail_alt() {
        return e_mail_alt;
    }

    public void setE_mail_alt(String e_mail_alt) {
        this.e_mail_alt = e_mail_alt;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCod_estudio() {
        return cod_estudio;
    }

    public void setCod_estudio(String cod_estudio) {
        this.cod_estudio = cod_estudio;
    }

    public String getCod_ins() {
        return cod_ins;
    }

    public void setCod_ins(String cod_ins) {
        this.cod_ins = cod_ins;
    }

    public Integer getAno_est() {
        return ano_est;
    }

    public void setAno_est(Integer ano_est) {
        this.ano_est = ano_est;
    }

    public Integer getGraduado() {
        return graduado;
    }

    public void setGraduado(Integer graduado) {
        this.graduado = graduado;
    }

    public LocalDateTime getFec_gra() {
        return fec_gra;
    }

    public void setFec_gra(LocalDateTime fec_gra) {
        this.fec_gra = fec_gra;
    }

    public String getNro_tar() {
        return nro_tar;
    }

    public void setNro_tar(String nro_tar) {
        this.nro_tar = nro_tar;
    }

    public Integer getInd_can() {
        return ind_can;
    }

    public void setInd_can(Integer ind_can) {
        this.ind_can = ind_can;
    }

    public String getTipo_est() {
        return tipo_est;
    }

    public void setTipo_est(String tipo_est) {
        this.tipo_est = tipo_est;
    }

    public String getCod_idi() {
        return cod_idi;
    }

    public void setCod_idi(String cod_idi) {
        this.cod_idi = cod_idi;
    }

    public String getNom_fam() {
        return nom_fam;
    }

    public void setNom_fam(String nom_fam) {
        this.nom_fam = nom_fam;
    }

    public Integer getEst_civ_fam() {
        return est_civ_fam;
    }

    public void setEst_civ_fam(Integer est_civ_fam) {
        this.est_civ_fam = est_civ_fam;
    }

    public Integer getInf_veridica() {
        return inf_veridica;
    }

    public void setInf_veridica(Integer inf_veridica) {
        this.inf_veridica = inf_veridica;
    }

    public LocalDateTime getFec_registro() {
        return fec_registro;
    }

    public void setFec_registro(LocalDateTime fec_registro) {
        this.fec_registro = fec_registro;
    }

    public String getCod_calif() {
        return cod_calif;
    }

    public void setCod_calif(String cod_calif) {
        this.cod_calif = cod_calif;
    }

    public String getCod_hab() {
        return cod_hab;
    }

    public void setCod_hab(String cod_hab) {
        this.cod_hab = cod_hab;
    }

    public String getAp1_fam() {
        return ap1_fam;
    }

    public void setAp1_fam(String ap1_fam) {
        this.ap1_fam = ap1_fam;
    }

    public String getAp2_fam() {
        return ap2_fam;
    }

    public void setAp2_fam(String ap2_fam) {
        this.ap2_fam = ap2_fam;
    }

    public String getTip_fam() {
        return tip_fam;
    }

    public void setTip_fam(String tip_fam) {
        this.tip_fam = tip_fam;
    }

    public String getTip_ide() {
        return tip_ide;
    }

    public void setTip_ide(String tip_ide) {
        this.tip_ide = tip_ide;
    }

    public String getNum_ced() {
        return num_ced;
    }

    public void setNum_ced(String num_ced) {
        this.num_ced = num_ced;
    }

    public LocalDateTime getFec_nac() {
        return fec_nac;
    }

    public void setFec_nac(LocalDateTime fec_nac) {
        this.fec_nac = fec_nac;
    }

    public Integer getSex_fam() {
        return sex_fam;
    }

    public void setSex_fam(Integer sex_fam) {
        this.sex_fam = sex_fam;
    }

    public String getNiv_est() {
        return niv_est;
    }

    public void setNiv_est(String niv_est) {
        this.niv_est = niv_est;
    }

    public Integer getInd_comp() {
        return ind_comp;
    }

    public void setInd_comp(Integer ind_comp) {
        this.ind_comp = ind_comp;
    }

    public Integer getOcu_fam() {
        return ocu_fam;
    }

    public void setOcu_fam(Integer ocu_fam) {
        this.ocu_fam = ocu_fam;
    }

    public Integer getInd_sub() {
        return ind_sub;
    }

    public void setInd_sub(Integer ind_sub) {
        this.ind_sub = ind_sub;
    }

    public Integer getInd_pro() {
        return ind_pro;
    }

    public void setInd_pro(Integer ind_pro) {
        this.ind_pro = ind_pro;
    }

    public Integer getInd_conv() {
        return ind_conv;
    }

    public void setInd_conv(Integer ind_conv) {
        this.ind_conv = ind_conv;
    }

    public Integer getInd_modifica() {
        return ind_modifica;
    }

    public void setInd_modifica(Integer ind_modifica) {
        this.ind_modifica = ind_modifica;
    }

    public Integer getInd_acepta() {
        return ind_acepta;
    }

    public void setInd_acepta(Integer ind_acepta) {
        this.ind_acepta = ind_acepta;
    }

    public Integer getEst_civ_emp() {
        return est_civ_emp;
    }

    public void setEst_civ_emp(Integer est_civ_emp) {
        this.est_civ_emp = est_civ_emp;
    }
}
