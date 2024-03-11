package com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers;

import jakarta.persistence.*;

@Entity
@Table(name = "Redes_Sociales")
public class RedesSocialesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cod_emp")
    private String codEmp;
    @Column(name = "cod_redsoc")
    private Integer codRedsoc;
    private String usuario_red;

    public RedesSocialesEntity() {
    }

    public RedesSocialesEntity(String cod_emp, Integer cod_redsoc, String usuario_red) {
        this.codEmp = cod_emp;
        this.codRedsoc = cod_redsoc;
        this.usuario_red = usuario_red;
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

    public Integer getCodRedsoc() {
        return codRedsoc;
    }

    public void setCodRedsoc(Integer codRedsoc) {
        this.codRedsoc = codRedsoc;
    }

    public String getUsuario_red() {
        return usuario_red;
    }

    public void setUsuario_red(String usuario_red) {
        this.usuario_red = usuario_red;
    }
}
