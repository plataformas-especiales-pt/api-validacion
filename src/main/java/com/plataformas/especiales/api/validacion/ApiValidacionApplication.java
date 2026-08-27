package com.plataformas.especiales.api.validacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiValidacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiValidacionApplication.class, args);
	}

}
