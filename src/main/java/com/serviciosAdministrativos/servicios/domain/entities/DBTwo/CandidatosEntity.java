package com.serviciosAdministrativos.servicios.domain.entities.DBTwo;

import jakarta.persistence.*;

@Entity
@Table(name = "candidatos")
public class CandidatosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idcrp;
    private Integer nroton;
    private String nombre;
    private String narc;
    private String Periodo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdcrp() {
        return idcrp;
    }

    public void setIdcrp(Integer idcrp) {
        this.idcrp = idcrp;
    }

    public Integer getNroton() {
        return nroton;
    }

    public void setNroton(Integer nroton) {
        this.nroton = nroton;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNarc() {
        return narc;
    }

    public void setNarc(String narc) {
        this.narc = narc;
    }

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String periodo) {
        Periodo = periodo;
    }
}
