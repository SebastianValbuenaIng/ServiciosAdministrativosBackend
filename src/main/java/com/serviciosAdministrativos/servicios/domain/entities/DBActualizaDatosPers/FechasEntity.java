package com.serviciosAdministrativos.servicios.domain.entities.DBActualizaDatosPers;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Fechas")
public class FechasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime fecha_ini;
    private LocalDateTime fecha_fin;

    public Integer getId() {
        return id;
    }

    public LocalDateTime getFecha_ini() {
        return fecha_ini;
    }

    public LocalDateTime getFecha_fin() {
        return fecha_fin;
    }
}
