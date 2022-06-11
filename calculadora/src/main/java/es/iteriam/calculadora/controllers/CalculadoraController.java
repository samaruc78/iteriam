/**
 * Clase Controller principal de la aplicacion.
 * 
 * Por buenas practicas,
 * se generaliza la logica en una sola funcion
 * valida para ampliaciones
 * 
 */

package es.iteriam.calculadora.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.iteriam.calculadora.models.MiModeloOperacion;
import es.iteriam.calculadora.servicio.CalculoService;
import io.corp.calculator.TracerImpl;

@RestController
public class CalculadoraController {

    @Autowired
    private CalculoService calculoServicio;

    @Autowired
    private TracerImpl tr;

    @PostMapping("/calcula")
    @ResponseBody
    public ResponseEntity<BigDecimal> calcula(@RequestBody MiModeloOperacion miOperacion) {

        final BigDecimal result = calculoServicio.calcula(miOperacion);
        tr.trace(result);

        return ResponseEntity.ok(result);

    }
}