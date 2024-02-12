package com.serviciosAdministrativos.servicios.domain.entities.DBTwo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "votantes")
public class VotanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificacion;
    private Integer copasst;
    private Integer ccl;
    private LocalDate fecha_copasst;
    private LocalDate fecha_ccl;

    public LocalDate getFecha_ccl() {
        return fecha_ccl;
    }

    public void setFecha_ccl(LocalDate fecha_ccl) {
        this.fecha_ccl = fecha_ccl;
    }

    public Integer getCcl() {
        return ccl;
    }

    public void setCcl(Integer ccl) {
        this.ccl = ccl;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public Integer getCopasst() {
        return copasst;
    }

    public void setCopasst(Integer copasst) {
        this.copasst = copasst;
    }

    public LocalDate getFecha_copasst() {
        return fecha_copasst;
    }

    public void setFecha_copasst(LocalDate fecha_copasst) {
        this.fecha_copasst = fecha_copasst;
    }
}
