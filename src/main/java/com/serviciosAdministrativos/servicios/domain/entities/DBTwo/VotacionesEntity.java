package com.serviciosAdministrativos.servicios.domain.entities.DBTwo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "votaciones")
public class VotacionesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idcrp;
    private Integer nroton;
    private LocalDateTime fecha;
    private String periodo;

    public VotacionesEntity() {
    }

    public VotacionesEntity(Integer idcrp, Integer nroton, LocalDateTime fecha, String periodo) {
        this.idcrp = idcrp;
        this.nroton = nroton;
        this.fecha = fecha;
        this.periodo = periodo;
    }

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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
