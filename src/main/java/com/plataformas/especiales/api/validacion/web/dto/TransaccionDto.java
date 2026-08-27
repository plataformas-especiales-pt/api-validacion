package com.plataformas.especiales.api.validacion.web.dto;

public record TransaccionDto(
    String operacion,
    String importe,
    String cliente,
    String secreto
) {}