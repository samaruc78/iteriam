/**
 * Engloba todos los manejadores de error  
 */

package es.iteriam.calculadora.advicers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import io.corp.calculator.TracerImpl;

@RestControllerAdvice
public class ExceptionControllerHandler {

    @Autowired
    private TracerImpl tr;

    // Operaciones no implementadas
    @ExceptionHandler(InvalidOperationException.class)
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public ErrorResponse invalidOperationHandler(
            InvalidOperationException ex, WebRequest request) {

        tr.trace(ex);

        ErrorResponse message = new ErrorResponse(
                HttpStatus.NOT_IMPLEMENTED.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return message;
    }

    // Cualquier request que no esté bien serializado con el modelo
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse invalidParamsHandler(
            HttpMessageNotReadableException ex, WebRequest request) {

        tr.trace(ex);

        ErrorResponse message = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return message;
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse invalidParamsHandler(
            ArithmeticException ex, WebRequest request) {

        tr.trace(ex);

        ErrorResponse message = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));        
        return message;
    }

}
