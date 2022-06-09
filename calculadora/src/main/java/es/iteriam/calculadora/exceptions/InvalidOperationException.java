/**
 * Hay una operacion que no esta mapeada
 */

package es.iteriam.calculadora.exceptions;

public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(String msg) {
        super(msg);
    }

}
