package com.serviciosAdministrativos.servicios.domain.entities.DBActualizacionDatos;

import jakarta.persistence.*;

@Entity
@Table(name = "gen_clasif4")
public class GenClasif4Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CODIGO;
    private String NOMBRE;
    private String estado;

    public Integer getCODIGO() {
        return CODIGO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public String getEstado() {
        return estado;
    }
}
