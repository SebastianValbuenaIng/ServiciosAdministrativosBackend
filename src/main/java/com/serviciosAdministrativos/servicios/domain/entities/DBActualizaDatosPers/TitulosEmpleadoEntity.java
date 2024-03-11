package com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers;

import jakarta.persistence.*;

@Entity
@Table(name = "Titulos_Empleado")
public class TitulosEmpleadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cod_emp")
    private String codEmp;
    private String cod_estudio;
    private String archivo;
    private String cod_ins;
    private Integer ano_est;
    private String fec_gra;
    private String nro_tar;

    public TitulosEmpleadoEntity() {
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

    public String getCod_estudio() {
        return cod_estudio;
    }

    public void setCod_estudio(String cod_estudio) {
        this.cod_estudio = cod_estudio;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getCod_ins() {
        return cod_ins;
    }

    public void setCod_ins(String cod_ins) {
        this.cod_ins = cod_ins;
    }

    public Integer getAno_est() {
        return ano_est;
    }

    public void setAno_est(Integer ano_est) {
        this.ano_est = ano_est;
    }

    public String getFec_gra() {
        return fec_gra;
    }

    public void setFec_gra(String fec_gra) {
        this.fec_gra = fec_gra;
    }

    public String getNro_tar() {
        return nro_tar;
    }

    public void setNro_tar(String nro_tar) {
        this.nro_tar = nro_tar;
    }
}
