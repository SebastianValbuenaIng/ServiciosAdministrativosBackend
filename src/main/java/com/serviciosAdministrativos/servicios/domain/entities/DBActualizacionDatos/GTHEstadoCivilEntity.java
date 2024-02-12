package com.serviciosAdministrativos.servicios.domain.entities.DBActualizacionDatos;

import jakarta.persistence.*;

@Entity
@Table(name = "GTH_EstCivil")
public class GTHEstadoCivilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod_est;
    private String des_est;

    public Integer getCod_est() {
        return cod_est;
    }

    public String getDes_est() {
        return des_est;
    }
}
