package com.plataformas.especiales.api.validacion.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.plataformas.especiales.api.validacion.service.ValidacionTransaccionService;
import com.plataformas.especiales.api.validacion.web.client.apitransaccion.ApiTransaccionClient;
import com.plataformas.especiales.api.validacion.web.dto.RespuestaTransaccionDto;
import com.plataformas.especiales.api.validacion.web.dto.SolicitudTransaccionDto;
import com.plataformas.especiales.api.validacion.web.dto.TransaccionDto;
import com.plataformas.especiales.api.validacion.web.exception.CifradoException;

@Service
public class ValidacionTransaccionServiceImpl implements ValidacionTransaccionService {

    private final String claveSecreta;
    private final ApiTransaccionClient apiTransaccionClient;

    public ValidacionTransaccionServiceImpl(
            @Value("${app.encryption.secret}") String claveSecreta,
            ApiTransaccionClient apiTransaccionClient) {
        this.claveSecreta = claveSecreta;
        this.apiTransaccionClient = apiTransaccionClient;
    }

    @Override
    public RespuestaTransaccionDto procesarTransaccion(SolicitudTransaccionDto solicitud) {
        String textoDescifrado = descifrar(solicitud.secreto());
        TransaccionDto transaccionDto = new TransaccionDto(
                solicitud.operacion(),
                solicitud.importe(),
                solicitud.cliente(),
                textoDescifrado);
        return apiTransaccionClient.registrarTransaccion(transaccionDto);
    }

    private String descifrar(String textoCifrado) {
        try {
            SecretKeySpec llave = new SecretKeySpec(claveSecreta.getBytes(StandardCharsets.UTF_8), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, llave);

            byte[] bytesDescifrados = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
            return new String(bytesDescifrados, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new CifradoException("Error al ejecutar el descifrado del atributo secreto", e);
        }
    }
}
