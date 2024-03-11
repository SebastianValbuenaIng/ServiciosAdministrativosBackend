package com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request;

import java.util.List;
import java.util.Map;

public class InformacionEmpleadoRequest {
    private Long tel_celular;
    private String cod_pais;
    private String cod_departamento;
    private String cod_ciudad;
    private Integer cod_estado_civil;
    private String email_alterno;
    private String direccion_residencia;
    private String ubicacion;
    private String usr_num_ext;
    private Integer confirmarVericidad;
    private Integer aceptarTratamiento;
    private Integer adicionoEstudios;
    private List<Map<String, Object>> red_social;

    public InformacionEmpleadoRequest(Long tel_celular, String cod_pais, String cod_departamento, String cod_ciudad, Integer cod_estado_civil, String email_alterno, String direccion_residencia, String ubicacion, String usr_num_ext, Integer confirmarVericidad, Integer aceptarTratamiento, Integer adicionoEstudios, List<Map<String, Object>> red_social) {
        this.tel_celular = tel_celular;
        this.cod_pais = cod_pais;
        this.cod_departamento = cod_departamento;
        this.cod_ciudad = cod_ciudad;
        this.cod_estado_civil = cod_estado_civil;
        this.email_alterno = email_alterno;
        this.direccion_residencia = direccion_residencia;
        this.ubicacion = ubicacion;
        this.usr_num_ext = usr_num_ext;
        this.confirmarVericidad = confirmarVericidad;
        this.aceptarTratamiento = aceptarTratamiento;
        this.adicionoEstudios = adicionoEstudios;
        this.red_social = red_social;
    }

    public Long getTel_celular() {
        return tel_celular;
    }

    public void setTel_celular(Long tel_celular) {
        this.tel_celular = tel_celular;
    }

    public String getCod_pais() {
        return cod_pais;
    }

    public void setCod_pais(String cod_pais) {
        this.cod_pais = cod_pais;
    }

    public String getCod_departamento() {
        return cod_departamento;
    }

    public void setCod_departamento(String cod_departamento) {
        this.cod_departamento = cod_departamento;
    }

    public String getCod_ciudad() {
        return cod_ciudad;
    }

    public void setCod_ciudad(String cod_ciudad) {
        this.cod_ciudad = cod_ciudad;
    }

    public Integer getCod_estado_civil() {
        return cod_estado_civil;
    }

    public void setCod_estado_civil(Integer cod_estado_civil) {
        this.cod_estado_civil = cod_estado_civil;
    }

    public String getEmail_alterno() {
        return email_alterno;
    }

    public void setEmail_alterno(String email_alterno) {
        this.email_alterno = email_alterno;
    }

    public String getDireccion_residencia() {
        return direccion_residencia;
    }

    public void setDireccion_residencia(String direccion_residencia) {
        this.direccion_residencia = direccion_residencia;
    }

    public List<Map<String, Object>> getRed_social() {
        return red_social;
    }

    public void setRed_social(List<Map<String, Object>> red_social) {
        this.red_social = red_social;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUsr_num_ext() {
        return usr_num_ext;
    }

    public void setUsr_num_ext(String usr_num_ext) {
        this.usr_num_ext = usr_num_ext;
    }

    public Integer getConfirmarVericidad() {
        return confirmarVericidad;
    }

    public void setConfirmarVericidad(Integer confirmarVericidad) {
        this.confirmarVericidad = confirmarVericidad;
    }

    public Integer getAceptarTratamiento() {
        return aceptarTratamiento;
    }

    public void setAceptarTratamiento(Integer aceptarTratamiento) {
        this.aceptarTratamiento = aceptarTratamiento;
    }

    public Integer getAdicionoEstudios() {
        return adicionoEstudios;
    }

    public void setAdicionoEstudios(Integer adicionoEstudios) {
        this.adicionoEstudios = adicionoEstudios;
    }
}
