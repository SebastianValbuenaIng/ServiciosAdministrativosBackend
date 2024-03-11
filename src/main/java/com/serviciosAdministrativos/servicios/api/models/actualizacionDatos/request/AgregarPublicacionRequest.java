package com.serviciosAdministrativos.servicios.api.models.actualizacionDatos.request;

import java.time.LocalDate;

public class AgregarPublicacionRequest {
    private String titulo_public;
    private LocalDate fecha_public;
    private String editorial;
    private String isbn;

    public AgregarPublicacionRequest(String titulo_public, LocalDate fecha_public, String editorial, String isbn) {
        this.titulo_public = titulo_public;
        this.fecha_public = fecha_public;
        this.editorial = editorial;
        this.isbn = isbn;
    }

    public String getTitulo_public() {
        return titulo_public;
    }

    public void setTitulo_public(String titulo_public) {
        this.titulo_public = titulo_public;
    }

    public LocalDate getFecha_public() {
        return fecha_public;
    }

    public void setFecha_public(LocalDate fecha_public) {
        this.fecha_public = fecha_public;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
