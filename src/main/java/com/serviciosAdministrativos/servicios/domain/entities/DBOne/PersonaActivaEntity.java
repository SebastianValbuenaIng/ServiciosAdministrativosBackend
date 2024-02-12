package com.serviciosAdministrativos.servicios.domain.entities.DBOne;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas_activas")
public class PersonaActivaEntity {
    @Id
    private Integer id;
    private String nombre;
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Column(name = "nro_documento")
    private String nroDocumento;
    @Column(name = "emplid")
    private String emplId;
    @Column(name = "email")
    private String email;
    @Column(name = "area")
    private String area;
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Column(name = "tipo_rol")
    private String tipoRol;
    @Column(name = "estado")
    private String estado;

    public PersonaActivaEntity() {
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public String getEmplId() {
        return emplId;
    }

    public String getEmail() {
        return email;
    }

    public String getArea() {
        return area;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public String getEstado() {
        return estado;
    }
}
