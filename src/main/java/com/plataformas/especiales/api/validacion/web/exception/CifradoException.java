package com.plataformas.especiales.api.validacion.web.exception;

public class CifradoException extends RuntimeException {

    public CifradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
