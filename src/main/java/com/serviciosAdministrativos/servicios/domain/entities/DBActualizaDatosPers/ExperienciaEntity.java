package com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Experiencia")
public class ExperienciaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cod_emp")
    private String codEmp;
    @Column(name = "nom_empr")
    private String nomEmpr;
    private String nom_car;
    private Integer area_exp;
    private String des_fun;
    private Integer tpo_exp;
    private String mot_ret;
    private String jefe_inm;
    private String num_tel;
    private LocalDateTime fec_ing;
    private LocalDateTime fec_ter;

    public ExperienciaEntity() {
    }

    public ExperienciaEntity(String codEmp, String nomEmpr, String nom_car, Integer area_exp, String des_fun, Integer tpo_exp, String mot_ret, String jefe_inm, String num_tel, LocalDateTime fec_ing, LocalDateTime fec_ter) {
        this.codEmp = codEmp;
        this.nomEmpr = nomEmpr;
        this.nom_car = nom_car;
        this.area_exp = area_exp;
        this.des_fun = des_fun;
        this.tpo_exp = tpo_exp;
        this.mot_ret = mot_ret;
        this.jefe_inm = jefe_inm;
        this.num_tel = num_tel;
        this.fec_ing = fec_ing;
        this.fec_ter = fec_ter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomEmpr() {
        return nomEmpr;
    }

    public void setNomEmpr(String nomEmpr) {
        this.nomEmpr = nomEmpr;
    }

    public String getNom_car() {
        return nom_car;
    }

    public void setNom_car(String nom_car) {
        this.nom_car = nom_car;
    }

    public String getDes_fun() {
        return des_fun;
    }

    public void setDes_fun(String des_fun) {
        this.des_fun = des_fun;
    }

    public String getMot_ret() {
        return mot_ret;
    }

    public void setMot_ret(String mot_ret) {
        this.mot_ret = mot_ret;
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

    public String getCodEmp() {
        return codEmp;
    }

    public void setCodEmp(String codEmp) {
        this.codEmp = codEmp;
    }

    public Integer getArea_exp() {
        return area_exp;
    }

    public void setArea_exp(Integer area_exp) {
        this.area_exp = area_exp;
    }

    public Integer getTpo_exp() {
        return tpo_exp;
    }

    public void setTpo_exp(Integer tpo_exp) {
        this.tpo_exp = tpo_exp;
    }

    public String getJefe_inm() {
        return jefe_inm;
    }

    public void setJefe_inm(String jefe_inm) {
        this.jefe_inm = jefe_inm;
    }
}