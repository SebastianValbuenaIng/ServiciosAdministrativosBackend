package com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers;

import jakarta.persistence.*;

@Entity
@Table(name = "Idiomas")
public class IdiomasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cod_emp")
    private String codEmp;
    @Column(name = "cod_idi")
    private String codIdi;
    private String cod_calif;
    private String cod_hab;

    public IdiomasEntity() {
    }

    public IdiomasEntity(String codIdi, String codEmp, String cod_calif, String cod_hab) {
        this.codIdi = codIdi;
        this.cod_calif = cod_calif;
        this.cod_hab = cod_hab;
        this.codEmp = codEmp;
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

    public String getCodIdi() {
        if (codIdi != null) {
            return codIdi.trim();
        }

        return codIdi;
    }

    public void setCodIdi(String codIdi) {
        this.codIdi = codIdi;
    }

    public String getCod_calif() {
        if (cod_calif != null) {
            return cod_calif.trim();
        }

        return cod_calif;
    }

    public void setCod_calif(String cod_calif) {
        this.cod_calif = cod_calif;
    }

    public String getCod_hab() {
        if (cod_hab != null) {
            return cod_hab.trim();
        }

        return cod_hab;
    }

    public void setCod_hab(String cod_hab) {
        this.cod_hab = cod_hab;
    }
}
