package com.serviciosAdministrativos.servicios.util.errors;

public class SecurityError extends RuntimeException{
    public SecurityError(String message) {
        super(message);
    }
}
