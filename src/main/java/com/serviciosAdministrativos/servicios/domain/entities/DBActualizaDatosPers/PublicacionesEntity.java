package com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Publicaciones")
public class PublicacionesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "cod_emp")
    private String codEmp;
    private String titulo_public;
    private String fecha_public;
    private String editorial;
    private String isbn;

    public PublicacionesEntity() {
    }

    public PublicacionesEntity(String codEmp, String titulo_public, String fecha_public, String editorial, String isbn) {
        this.codEmp = codEmp;
        this.titulo_public = titulo_public;
        this.fecha_public = fecha_public;
        this.editorial = editorial;
        this.isbn = isbn;
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

    public String getTitulo_public() {
        return titulo_public;
    }

    public void setTitulo_public(String titulo_public) {
        this.titulo_public = titulo_public;
    }

    public String getFecha_public() {
        return fecha_public;
    }

    public void setFecha_public(String fecha_public) {
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
