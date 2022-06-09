/**
 * Clase derivada de MiModeloOperacion 
 * para realizar su tarea
 * con los params del padre (MiModeloOperacion)
 * Cumpliendo así con los principios de SOLID
 */

package es.iteriam.calculadora.controllers;

import java.math.BigDecimal;

import es.iteriam.calculadora.models.MiModeloOperacion;

public class Resta extends MiModeloOperacion implements MathOperation {

    public Resta(){
        super();        
    }

    public Resta(BigDecimal a, BigDecimal b){
        super(a, b);        
    }

    @Override
    public BigDecimal calculate() {        
        return this.getA().subtract(this.getB());
    }

}
