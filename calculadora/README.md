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

## Change Log
Registro de cambios de la prueba técnica

## Work In Progress (WIP)
- Se crea un paquete para excepciones (y sus clases de test) y se incorporan las siguientes:
-- ExceptionControllerHandler que engloba todos los manejadores de error
-- InvalidOperationException como excepcion concreta para operaciones invalidas (incluyendo las no implementadas aun)
-- InputParamException en el caso que haya operandos que no sean números (como Strings, chars...)
-- ErrorRespone como salida de error con campos de informacion como fecha, estadoHTTP, mensaje

## [0.0.3] - 2022-06-09
### Fixed
- No utilizar llamadas a System.err.println. Se usa la librería de tracer.
- Se crea la clase TracerImplConfig con un Bean al constructor TracerImpl para no instanciar dentro de los componentes.
- Se elimina el miembro explicito MiModeloOperacion de la clase CalculadoraController por ser redundante e innecesario.
- Se usa la anotación @BeforeEach de JUnit en el método cargaModel()
- Mover clases MathOperation, MathOperationFactory, Resta, Suma al paquete es.iteriam.calculadora.models


## [0.0.2] - 2022-06-09
### Fixed
- Se han añadido clases de test por capa.
- Refactorizacion de clases como StandaloneControllerTests a CalculadoraControllerTest y código duplicado.
- Revisión de métodos estáticos y su visibilidad.
- Dependencia lombok eliminada.
- Inclusión de las librerías tracer y su empaquetado en carpeta lib
- Se crea una clase Factory (MathOperationFactory) que instancia objetos según la operación solicitada (suma, resta, etc.)	
- Se crea la interfaz MathOperation con el método calculate para implementación de las clases derivadas según operación solicitada.	Cada clase derivada, sobrecarga la funcion calculate y de esta manera se extiende la funcionalidad según los principios SOLID.
- La clase factory (MathOperationFactory) es la que acarrea la implementación de los cambios, liberando al resto de clases de ser susceptibles a estos cambios.
- Las clases derivadas de MiModeloOperacion como son Suma y Resta ademas implementan la funcion calculate (mapeada al controller principal) y heredan los miembros del Modelo del Request donde se dispone de la información de entrada (operandos y operador).
- El tipo de respuesta del controlador se ha cambiado a ResponseEntity<BigDecimal>
- Se cambia a @RequestBody de esta manera se pueden hacer peticiones POST enviando objetos segun la clase MiModeloOperacion (2 BigDecimal y un String para indicar la operación)

## [0.0.1] - 2022-06-08
- Creación de la aplicación.

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
mvn -N io.takari:maven:wrapper
./mvnw spring-boot:run
```

## Uso de la API
![POSTMAN](https://github.com/samaruc78/iteriam/blob/main/calculadora/APICall.png)

## TO-DO
# Docker
Reservado para llevar a cabo instrucciones que permitan "dockerizar" la aplicación.