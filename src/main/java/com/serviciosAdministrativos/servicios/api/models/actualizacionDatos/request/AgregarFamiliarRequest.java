package com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request;

import java.time.LocalDate;

public class AgregarFamiliarRequest {
    private String apellido_uno_familiar;
    private String apellido_dos_familiar;
    private String nombres_familiar;
    private String parentesco_familiar;
    private String tipo_documento_familiar;
    private String numero_documento_familiar;
    private LocalDate fecha_nacimiento_familiar;
    private Integer genero_familiar;
    private Integer estado_civil_familiar;
    private Integer ocupacion_familiar;
    private Integer recibe_sub_familiar;
    private Integer beneficiario_pos_familiar;
    private Integer convive_conmigo_familiar;
    private String nivel_estudios_familiar;
    private Integer termino_estudios_familiar;

    public AgregarFamiliarRequest(String apellido_uno_familiar, String apellido_dos_familiar, String nombres_familiar, String parentesco_familiar, String tipo_documento_familiar, String numero_documento_familiar, LocalDate fecha_nacimiento_familiar, Integer genero_familiar, Integer estado_civil_familiar, Integer ocupacion_familiar, Integer recibe_sub_familiar, Integer beneficiario_pos_familiar, Integer convive_conmigo_familiar, String nivel_estudios_familiar, Integer termino_estudios_familiar) {
        this.apellido_uno_familiar = apellido_uno_familiar;
        this.apellido_dos_familiar = apellido_dos_familiar;
        this.nombres_familiar = nombres_familiar;
        this.parentesco_familiar = parentesco_familiar;
        this.tipo_documento_familiar = tipo_documento_familiar;
        this.numero_documento_familiar = numero_documento_familiar;
        this.fecha_nacimiento_familiar = fecha_nacimiento_familiar;
        this.genero_familiar = genero_familiar;
        this.estado_civil_familiar = estado_civil_familiar;
        this.ocupacion_familiar = ocupacion_familiar;
        this.recibe_sub_familiar = recibe_sub_familiar;
        this.beneficiario_pos_familiar = beneficiario_pos_familiar;
        this.convive_conmigo_familiar = convive_conmigo_familiar;
        this.nivel_estudios_familiar = nivel_estudios_familiar;
        this.termino_estudios_familiar = termino_estudios_familiar;
    }

    public String getApellido_uno_familiar() {
        return apellido_uno_familiar;
    }

    public void setApellido_uno_familiar(String apellido_uno_familiar) {
        this.apellido_uno_familiar = apellido_uno_familiar;
    }

    public String getApellido_dos_familiar() {
        return apellido_dos_familiar;
    }

    public void setApellido_dos_familiar(String apellido_dos_familiar) {
        this.apellido_dos_familiar = apellido_dos_familiar;
    }

    public String getNombres_familiar() {
        return nombres_familiar;
    }

    public void setNombres_familiar(String nombres_familiar) {
        this.nombres_familiar = nombres_familiar;
    }

    public String getParentesco_familiar() {
        return parentesco_familiar;
    }

    public void setParentesco_familiar(String parentesco_familiar) {
        this.parentesco_familiar = parentesco_familiar;
    }

    public String getTipo_documento_familiar() {
        return tipo_documento_familiar;
    }

    public void setTipo_documento_familiar(String tipo_documento_familiar) {
        this.tipo_documento_familiar = tipo_documento_familiar;
    }

    public String getNumero_documento_familiar() {
        return numero_documento_familiar;
    }

    public void setNumero_documento_familiar(String numero_documento_familiar) {
        this.numero_documento_familiar = numero_documento_familiar;
    }

    public LocalDate getFecha_nacimiento_familiar() {
        return fecha_nacimiento_familiar;
    }

    public void setFecha_nacimiento_familiar(LocalDate fecha_nacimiento_familiar) {
        this.fecha_nacimiento_familiar = fecha_nacimiento_familiar;
    }

    public Integer getGenero_familiar() {
        return genero_familiar;
    }

    public void setGenero_familiar(Integer genero_familiar) {
        this.genero_familiar = genero_familiar;
    }

    public Integer getEstado_civil_familiar() {
        return estado_civil_familiar;
    }

    public void setEstado_civil_familiar(Integer estado_civil_familiar) {
        this.estado_civil_familiar = estado_civil_familiar;
    }

    public Integer getOcupacion_familiar() {
        return ocupacion_familiar;
    }

    public void setOcupacion_familiar(Integer ocupacion_familiar) {
        this.ocupacion_familiar = ocupacion_familiar;
    }

    public Integer getRecibe_sub_familiar() {
        return recibe_sub_familiar;
    }

    public void setRecibe_sub_familiar(Integer recibe_sub_familiar) {
        this.recibe_sub_familiar = recibe_sub_familiar;
    }

    public Integer getBeneficiario_pos_familiar() {
        return beneficiario_pos_familiar;
    }

    public void setBeneficiario_pos_familiar(Integer beneficiario_pos_familiar) {
        this.beneficiario_pos_familiar = beneficiario_pos_familiar;
    }

    public Integer getConvive_conmigo_familiar() {
        return convive_conmigo_familiar;
    }

    public void setConvive_conmigo_familiar(Integer convive_conmigo_familiar) {
        this.convive_conmigo_familiar = convive_conmigo_familiar;
    }

    public String getNivel_estudios_familiar() {
        return nivel_estudios_familiar;
    }

    public void setNivel_estudios_familiar(String nivel_estudios_familiar) {
        this.nivel_estudios_familiar = nivel_estudios_familiar;
    }

    public Integer getTermino_estudios_familiar() {
        return termino_estudios_familiar;
    }

    public void setTermino_estudios_familiar(Integer termino_estudios_familiar) {
        this.termino_estudios_familiar = termino_estudios_familiar;
    }
}