package com.plataformas.especiales.api.validacion.web.client.apitransaccion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.plataformas.especiales.api.validacion.web.dto.RespuestaTransaccionDto;
import com.plataformas.especiales.api.validacion.web.dto.TransaccionDto;


@FeignClient(name = "api-transaction", url = "${app.feign.api-transaccion.url}")
public interface ApiTransaccionClient {

    @PostMapping("/api/v1/transacciones")
    RespuestaTransaccionDto registrarTransaccion(@RequestBody TransaccionDto solicitud);
}
