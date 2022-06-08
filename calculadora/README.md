# Prueba Técnica Iteriam ![N|Solid](https://www.iteriam.es/img/iteriam_logo.png)
## _Test nº 4. Calculadora_
[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
## Objeto
La presente prueba es un proyecto en github que soluciona el problema planteado por Iteriam
mediante indicaciones por correo electrónico.
El proyecto se encuentra a disposición desde este enlace:
https://github.com/samaruc78/sanitasTest4
## Alcance
- Solución a los puntos solicitados, incluidas pruebas unitarias.
- Inyección de dependencias via Maven facilitadas en el archivo pom.xml
- Apoyo en la herramienta [POSTMAN] https://www.postman.com/ para interactuar con el microservicio

## Estructura del proyecto
La estructura está distribuida en una carpeta para las clases:
**Controllers**
(para clases que negocien las solicitudes):
```sh
calculadora/src/main/java/es/iteriam/calculadora/controllers/
```

**Models**
(para clases DTO que representen entidades):
```sh
calculadora/src/main/java/es/iteriam/calculadora/models/
```

**Tests**
```sh
calculadora/src/test/
```
## Instalación
- Instalar Maven 3.x
- Mínimo emplear JDK 11
https://docs.microsoft.com/en-us/java/openjdk/download

- Descargar repositorio github
https://github.com/samaruc78/iteriam/archive/refs/heads/main.zip

- Definir la variable de entorno JAVA_HOME según S.O para que apunte a la JVM particular

```sh
cd calculadora
./mvnw spring-boot:run
```

## Uso de la API
![POSTMAN](https://github.com/samaruc78/iteriam/blob/main/calculadora/APICall.png)



## TO-DO
# Docker
Reservado para llevar a cabo instrucciones que permitan "dockerizar" la aplicación.