/**
 * Clase derivada de MiModeloOperacion 
 * para realizar su tarea
 * con los params del padre (MiModeloOperacion)
 * Cumpliendo así con los principios de SOLID
 */

package es.iteriam.calculadora.models;

import java.math.BigDecimal;

public class Suma extends MiModeloOperacion implements MathOperation {

    public Suma() {
        super();
    }

    public Suma(BigDecimal a, BigDecimal b) {
        super(a, b);
    }

    @Override
    public BigDecimal calculate() {
        return this.getA().add(this.getB());
    }
}
