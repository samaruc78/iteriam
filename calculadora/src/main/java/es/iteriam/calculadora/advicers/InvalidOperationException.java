/**
 * Hay una operacion que no esta mapeada
 */

package es.iteriam.calculadora.advicers;

public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(String msg) {
        super(msg);
    }
}
