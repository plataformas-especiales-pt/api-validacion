package com.plataformas.especiales.api.validacion.web.dto;

public record RespuestaTransaccionDto(
    String id,
    String estatus,
    String referencia,
    String operacion
) {}