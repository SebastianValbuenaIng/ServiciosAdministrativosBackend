package com.serviciosAdministrativos.servicios.util.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class ValidationErrorHandler {
    @ExceptionHandler(ServerError.class)
    public static ResponseEntity<Map<String, String>> handleException(ServerError e) {
        return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
    }

    @ExceptionHandler(SecurityError.class)
    public static ResponseEntity<Map<String, String>> handleValidation(SecurityError e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", e.getMessage()));
    }

    @ExceptionHandler(NotFoundError.class)
    public static ResponseEntity<Map<String, String>> handleNotFound(NotFoundError e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
    }

    public static ResponseEntity<Map<String, String>> validationError(BindingResult bindingResult) {
        return ResponseEntity.badRequest().body(Map.of("message", Objects
                        .requireNonNull(bindingResult.getFieldErrors().get(0).getDefaultMessage())));
    }
}