package com.serviciosAdministrativos.servicios.domain.entities.DBActualizacionDatos;

import jakarta.persistence.*;

@Entity
@Table(name = "GTH_Genero")
public class GTHGeneroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod_gen;
    private String des_gen;

    public Integer getCod_gen() {
        return cod_gen;
    }

    public String getDes_gen() {
        return des_gen;
    }
}