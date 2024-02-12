package com.serviciosAdministrativos.servicios.domain.entities.DBActualizacionDatos;

import jakarta.persistence.*;

@Entity
@Table(name = "gen_paises")
public class GenPaisesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod_pai;
    private String nom_pai;

    public Integer getCod_pai() {
        return cod_pai;
    }

    public String getNom_pai() {
        return nom_pai.trim();
    }
}