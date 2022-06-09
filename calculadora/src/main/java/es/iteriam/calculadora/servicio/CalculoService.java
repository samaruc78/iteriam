/**
 * Nivel de paquete:
 *  * Campa "service" donde reside la logica
 *  
 * Implementacion de las funciones aritmeticas
 * 
 * Por buenas practicas:
 * no modificar en ampliaciones.
 * Usar @MathOperationFactory
 * 
 */

package es.iteriam.calculadora.servicio;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import es.iteriam.calculadora.models.MathOperation;
import es.iteriam.calculadora.models.MathOperationFactory;
import es.iteriam.calculadora.models.MiModeloOperacion;

@Service
public class CalculoService {

    public BigDecimal calcula(MiModeloOperacion model) {
        MathOperationFactory operacionFactory = new MathOperationFactory();        
        MathOperation operacion = operacionFactory.getOperation(model);        
        return operacion.calculate();        
    }
    
}