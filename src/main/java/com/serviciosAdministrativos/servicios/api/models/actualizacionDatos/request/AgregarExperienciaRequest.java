package com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request;

import java.time.LocalDate;

public class AgregarExperienciaRequest {
    private String nombre_empresa;
    private String cargo;
    private String area_empresa;
    private String funciones;
    private String duracion;
    private String motivo_retiro;
    private String nombre_jefe;
    private Integer telefono;
    private LocalDate fecha_ingreso;
    private LocalDate fecha_terminacion;

    public AgregarExperienciaRequest(String nombre_empresa, String cargo, String area_empresa, String funciones, String duracion, String motivo_retiro, String nombre_jefe, Integer telefono, LocalDate fecha_ingreso, LocalDate fecha_terminacion) {
        this.nombre_empresa = nombre_empresa;
        this.cargo = cargo;
        this.area_empresa = area_empresa;
        this.funciones = funciones;
        this.duracion = duracion;
        this.motivo_retiro = motivo_retiro;
        this.nombre_jefe = nombre_jefe;
        this.telefono = telefono;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_terminacion = fecha_terminacion;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getArea_empresa() {
        return area_empresa;
    }

    public void setArea_empresa(String area_empresa) {
        this.area_empresa = area_empresa;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getMotivo_retiro() {
        return motivo_retiro;
    }

    public void setMotivo_retiro(String motivo_retiro) {
        this.motivo_retiro = motivo_retiro;
    }

    public String getNombre_jefe() {
        return nombre_jefe;
    }

    public void setNombre_jefe(String nombre_jefe) {
        this.nombre_jefe = nombre_jefe;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public LocalDate getFecha_terminacion() {
        return fecha_terminacion;
    }

    public void setFecha_terminacion(LocalDate fecha_terminacion) {
        this.fecha_terminacion = fecha_terminacion;
    }
}
