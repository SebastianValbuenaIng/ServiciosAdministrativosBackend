package com.serviciosAdministrativos.servicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// Documentación API's del proyecto: http://localhost:8030/swagger-ui/index.html
@SpringBootApplication
@EnableScheduling
public class ServiciosApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiciosApplication.class, args);
    }
}