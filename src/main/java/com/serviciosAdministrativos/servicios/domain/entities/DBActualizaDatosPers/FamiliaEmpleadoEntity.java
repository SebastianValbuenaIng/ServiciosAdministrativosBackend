package com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Familia_Empleado")
public class FamiliaEmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cod_emp")
    private String codEmp;
    @Column(name = "ap1_fam")
    private String ap1Fam;
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

    public FamiliaEmpleadoEntity() {
    }

    public FamiliaEmpleadoEntity(String cod_emp, String ap1Fam, String ap2_fam, String nom_fam, String tip_fam, String tip_ide, String num_ced, LocalDateTime fec_nac, Integer sex_fam, Integer est_civ_fam, String niv_est, Integer ind_comp, Integer ocu_fam, Integer ind_sub, Integer ind_pro, Integer ind_conv) {
        this.codEmp = cod_emp;
        this.ap1Fam = ap1Fam;
        this.ap2_fam = ap2_fam;
        this.nom_fam = nom_fam;
        this.tip_fam = tip_fam;
        this.tip_ide = tip_ide;
        this.num_ced = num_ced;
        this.fec_nac = fec_nac;
        this.sex_fam = sex_fam;
        this.est_civ_fam = est_civ_fam;
        this.niv_est = niv_est;
        this.ind_comp = ind_comp;
        this.ocu_fam = ocu_fam;
        this.ind_sub = ind_sub;
        this.ind_pro = ind_pro;
        this.ind_conv = ind_conv;
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

    public String getAp1Fam() {
        return ap1Fam;
    }

    public void setAp1Fam(String ap1Fam) {
        this.ap1Fam = ap1Fam;
    }

    public String getAp2_fam() {
        return ap2_fam;
    }

    public void setAp2_fam(String ap2_fam) {
        this.ap2_fam = ap2_fam;
    }

    public String getNom_fam() {
        return nom_fam;
    }

    public void setNom_fam(String nom_fam) {
        this.nom_fam = nom_fam;
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

    public Integer getEst_civ_fam() {
        return est_civ_fam;
    }

    public void setEst_civ_fam(Integer est_civ_fam) {
        this.est_civ_fam = est_civ_fam;
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
}
