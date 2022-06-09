/**
 * Nivel de paquete:
 *  * Campa "model" que conforma las entidades a usar
 * 
 * Clase entidad DTO para manejar
 * Operandos y
 * Operadores  
 * 
 */

package es.iteriam.calculadora.models;

import java.math.BigDecimal;

public class MiModeloOperacion {

    private String operador;
    private BigDecimal a;
    private BigDecimal b;

    public MiModeloOperacion() {
        this(
                new BigDecimal(0),
                new BigDecimal(0),
                "");
    }

    public MiModeloOperacion(String operador) {
        this(
                new BigDecimal(0),
                new BigDecimal(0),
                operador);
    }

    public MiModeloOperacion(BigDecimal a, BigDecimal b) {
        this(a, b, "");
    }

    public MiModeloOperacion(BigDecimal a, BigDecimal b, String operador) {
        this.a = a;
        this.b = b;
        this.operador = operador;
    }

    public BigDecimal getA() {
        return a;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public BigDecimal getB() {
        return b;
    }

    public void setB(BigDecimal b) {
        this.b = b;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

}