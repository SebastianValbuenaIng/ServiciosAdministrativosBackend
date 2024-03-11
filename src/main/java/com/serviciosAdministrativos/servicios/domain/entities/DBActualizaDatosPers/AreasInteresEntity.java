package com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers;

import jakarta.persistence.*;

@Entity
@Table(name = "Areas_Interes")
public class AreasInteresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cod_emp")
    private String codEmp;
    private Integer cod_area;

    public AreasInteresEntity() {
    }

    public AreasInteresEntity(String cod_emp, Integer cod_area) {
        this.codEmp = cod_emp;
        this.cod_area = cod_area;
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

    public Integer getCod_area() {
        return cod_area;
    }

    public void setCod_area(Integer cod_area) {
        this.cod_area = cod_area;
    }
}
