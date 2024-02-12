package com.serviciosAdministrativos.servicios;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Documentación API's del proyecto: http://localhost:8030/swagger-ui/index.html
@SpringBootApplication
public class ServiciosApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiciosApplication.class,args);
    }
}
