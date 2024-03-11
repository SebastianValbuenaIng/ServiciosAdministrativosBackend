package com.serviciosAdministrativos.servicios;

import com.serviciosAdministrativos.servicios.domain.repositories.DBActualizaDatosPers.DatosEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// Documentación API's del proyecto: http://localhost:8030/swagger-ui/index.html
@SpringBootApplication
@EnableScheduling
public class ServiciosApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ServiciosApplication.class, args);
    }

    @Autowired
    DatosEmpleadoRepository datosEmpleadoRepository;

    @Override
    public void run(String... args) throws Exception {
    }

}