/**
 * En el caso que haya operandos que no sean numeros
 * (Strings u otros tipos)
 */

package es.iteriam.calculadora.exceptions;

public class InputParamException extends RuntimeException {
    public InputParamException(String msg) {
        super(msg);
    }

}
