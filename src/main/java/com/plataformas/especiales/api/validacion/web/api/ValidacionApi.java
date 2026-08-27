package com.plataformas.especiales.api.validacion.web.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plataformas.especiales.api.validacion.service.ValidacionTransaccionService;
import com.plataformas.especiales.api.validacion.web.dto.RespuestaTransaccionDto;
import com.plataformas.especiales.api.validacion.web.dto.SolicitudTransaccionDto;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(
    origins = "http://localhost:4200"
)
@RestController
@RequestMapping("/api/v1/validacion/transacciones")
public class ValidacionApi {

    private final ValidacionTransaccionService validacionTransaccionService;

    public ValidacionApi(ValidacionTransaccionService validacionTransaccionService) {
        this.validacionTransaccionService = validacionTransaccionService;
    }

    @PostMapping
    public ResponseEntity<RespuestaTransaccionDto> procesarTransaccion(
            @Valid @RequestBody SolicitudTransaccionDto soliitud) {
        return ResponseEntity.ok(validacionTransaccionService.procesarTransaccion(soliitud));
    }
}
