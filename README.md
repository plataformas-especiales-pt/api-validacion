# API Validación (`api-validacion`)

Microservicio desarrollado en Java 17 y Spring Boot 3 encargado de recibir las peticiones del cliente, validar las estructuras de entrada, realizar el descifrado de campos sensibles mediante AES-256 y transmitir la información procesada hacia la API de persistencia (`api-transacciones`) a través de OpenFeign.

---

## 📋 Requisitos Previos

* **JDK:** Versión 17 o superior.
* **Maven:** 3.8+ (o utilizar el ejecutable `./mvnw` incluido).

---

## ⚙️ Configuración de Variables de Entorno (`.env`)

El microservicio requiere las siguientes variables de entorno para su correcto funcionamiento:

```env
SECRET_KEY=PtPlataformasEspeciales2026Key32
API_TRANSACCION_URL=http://localhost:8081
```

> 📌 **Nota de revisión:** El archivo `.env` fue incluido deliberadamente dentro del repositorio con el objetivo de agilizar la ejecución y pruebas de la evaluación por parte del equipo revisor, evitando configuraciones manuales previas. La inclusión de este archivo responde a facilitar la revisión de la prueba y no a un desconocimiento de las buenas prácticas de seguridad sobre el manejo de secretos en control de versiones.

---

## 🚀 Guía de Ejecución

### Desde Visual Studio Code (Recomendado)
Abre el proyecto en VS Code e inicia el servicio desde el panel **Run and Debug** utilizando la siguiente configuración cargada en `.vscode/launch.json`:

```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "name": "ApiValidacionApplication",
            "request": "launch",
            "mainClass": "com.plataformas.especiales.api.validacion.ApiValidacionApplication",
            "projectName": "api-validacion",
            "envFile": "${workspaceFolder}/.env"
        }
    ]
}
```

### Desde Terminal (Maven wrapper)
```bash
./mvnw spring-boot:run
```

---

## 📝 Aclaración sobre Comentarios y Documentación en Código

> ⚠️ **Nota sobre Clean Code:** La documentación interna (Javadoc/comentarios) del código fuente fue omitida debido a las restricciones de tiempo asignadas para el desarrollo de la prueba técnica. Se priorizó el cumplimiento total de la arquitectura, la cobertura funcional de requerimientos, la seguridad de extremos y la legibilidad del código.
