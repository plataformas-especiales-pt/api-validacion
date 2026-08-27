package com.plataformas.especiales.api.validacion.web.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail validationException(MethodArgumentNotValidException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                ex.getMessage());
        problemDetail.setTitle("Argumento de método inválido");
        problemDetail.setType(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/errors/bad-request")
                .build()
                .toUri());
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(CifradoException.class)
    public ProblemDetail manejarExcepcionCifrado(CifradoException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.UNPROCESSABLE_ENTITY,
                ex.getMessage());
        problemDetail.setTitle("Error de cifrado");
        problemDetail.setType(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/errors/unprocessable_entity")
                .build()
                .toUri());
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
