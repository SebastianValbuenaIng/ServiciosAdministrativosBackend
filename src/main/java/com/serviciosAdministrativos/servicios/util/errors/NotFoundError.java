package com.serviciosAdministrativos.servicios.util.errors;

public class NotFoundError extends RuntimeException {
    public NotFoundError(String message) {
        super(message);
    }
}
