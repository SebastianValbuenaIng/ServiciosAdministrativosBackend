package com.serviciosAdministrativos.servicios.util.errors;

public class ServerError extends RuntimeException {
    public ServerError(String message) {
        super(message);
    }
}
