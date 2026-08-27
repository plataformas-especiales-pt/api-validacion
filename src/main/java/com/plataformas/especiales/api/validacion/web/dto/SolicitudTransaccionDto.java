package com.plataformas.especiales.api.validacion.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record SolicitudTransaccionDto (
    @NotBlank(message = "El campo operacion es obligatorio")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", message = "El campo operacion solo debe contener letras")
    String operacion,

    @NotBlank(message = "El campo importe es obligatorio")
    @Pattern(regexp = "^\\d+(\\.\\d{2})?$", message = "El campo importe debe tener un formato monetario válido (p.e. 100.00)")
    String importe,

    @NotBlank(message = "El campo cliente es obligatorio")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$", message = "El campo cliente solo debe contener caracteres alfabéticos")
    String cliente,

    @NotBlank(message = "El campo secreto es obligatorio")
    String secreto
){}