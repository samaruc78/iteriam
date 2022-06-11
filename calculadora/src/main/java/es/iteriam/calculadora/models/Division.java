/**
 * Clase derivada de MiModeloOperacion 
 * para realizar su tarea
 * con los params del padre (MiModeloOperacion)
 * Cumpliendo así con los principios de SOLID
 */

package es.iteriam.calculadora.models;

import java.math.BigDecimal;

public class Division extends MiModeloOperacion implements MathOperation {

    public Division(){
        super();        
    }

    public Division(BigDecimal a, BigDecimal b){
        super(a, b);        
    }

    @Override
    public BigDecimal calculate() {        
        return this.getA().divide(this.getB());
    }

}