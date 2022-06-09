/**
 * Engloba todos los manejadores de error  
 */

package es.iteriam.calculadora.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import es.iteriam.calculadora.exceptions.ErrorResponse;
import es.iteriam.calculadora.exceptions.InputParamException;
import es.iteriam.calculadora.exceptions.InvalidOperationException;

@RestControllerAdvice
@ResponseBody
public class ExceptionControllerHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidOperationException.class)
    @ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED)
    public ErrorResponse invalidOperationHandler(
            InvalidOperationException ex, WebRequest request) {

        ErrorResponse message = new ErrorResponse(
                HttpStatus.NOT_IMPLEMENTED.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return message;
    }

    @ExceptionHandler(value={InputParamException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse inputParamHandler(
        InputParamException ex, WebRequest request) {

        ErrorResponse message = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return message;
    }

    // Excepcion por defecto
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse exceptionHandñler(
        Exception ex, WebRequest request) {

        ErrorResponse message = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return message;

    }

}
