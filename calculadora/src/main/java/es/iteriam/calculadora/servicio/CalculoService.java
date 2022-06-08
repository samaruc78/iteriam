/**
 * Nivel de paquete:
 *  * Campa "service" donde reside la logica
 *  
 * Implementacion de las funciones aritmeticas
 * 
 */

package es.iteriam.calculadora.servicio;

import es.iteriam.calculadora.models.MiModeloOperacion;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class CalculoService {


    public BigDecimal add (MiModeloOperacion model) {
        return model.getA().add(model.getB());
    }

    public BigDecimal subtract(MiModeloOperacion model) {
        return model.getA().subtract(model.getB());
    }

    public BigDecimal multiply(MiModeloOperacion model) {
        return model.getA().multiply(model.getB());
    }

    public BigDecimal divide(MiModeloOperacion model) {

        BigDecimal rstdo = new BigDecimal(0);

        // Manejamos excepcion por si divisor es 0
        try {
            rstdo = model.getA().divide(model.getB());
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }
        return rstdo;
    }

    /**
     * TO-DO function modulo. (a mod b)
     * 
     */
    // public BigDecimal modulo(MiModeloOperacion model) {
    //         No implementado 
    // }

}