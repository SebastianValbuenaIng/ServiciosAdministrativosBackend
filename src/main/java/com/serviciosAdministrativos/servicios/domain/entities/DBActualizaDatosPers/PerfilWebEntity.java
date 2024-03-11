package com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers;

import jakarta.persistence.*;

@Entity
@Table(name = "Perfil_Web")
public class PerfilWebEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cod_emp")
    private String codEmp;
    private String cargo_direc;
    private String membresias;
    private String reconocimientos;
    private String cargo_tit_web;
    private String parrafo1;
    private String parrafo2;

    public PerfilWebEntity() {
    }

    public PerfilWebEntity(String cod_emp, String cargo_direc, String membresias, String reconocimientos, String cargo_tit_web, String parrafo1, String parrafo2) {
        this.codEmp = cod_emp;
        this.cargo_direc = cargo_direc;
        this.membresias = membresias;
        this.reconocimientos = reconocimientos;
        this.cargo_tit_web = cargo_tit_web;
        this.parrafo1 = parrafo1;
        this.parrafo2 = parrafo2;
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

    public String getCargo_direc() {
        return cargo_direc;
    }

    public void setCargo_direc(String cargo_direc) {
        this.cargo_direc = cargo_direc;
    }

    public String getMembresias() {
        return membresias;
    }

    public void setMembresias(String membresias) {
        this.membresias = membresias;
    }

    public String getReconocimientos() {
        return reconocimientos;
    }

    public void setReconocimientos(String reconocimientos) {
        this.reconocimientos = reconocimientos;
    }

    public String getCargo_tit_web() {
        return cargo_tit_web;
    }

    public void setCargo_tit_web(String cargo_tit_web) {
        this.cargo_tit_web = cargo_tit_web;
    }

    public String getParrafo1() {
        return parrafo1;
    }

    public void setParrafo1(String parrafo1) {
        this.parrafo1 = parrafo1;
    }

    public String getParrafo2() {
        return parrafo2;
    }

    public void setParrafo2(String parrafo2) {
        this.parrafo2 = parrafo2;
    }
}
