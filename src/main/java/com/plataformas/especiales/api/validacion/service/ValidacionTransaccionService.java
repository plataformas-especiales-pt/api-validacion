package com.plataformas.especiales.api.validacion.service;

import com.plataformas.especiales.api.validacion.web.dto.RespuestaTransaccionDto;
import com.plataformas.especiales.api.validacion.web.dto.SolicitudTransaccionDto;

public interface ValidacionTransaccionService {
    RespuestaTransaccionDto procesarTransaccion(SolicitudTransaccionDto solicitud);
}
