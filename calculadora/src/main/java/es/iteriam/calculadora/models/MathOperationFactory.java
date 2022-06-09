/**
 * Esta clase sera objeto de cambios
 * cuando haya ampliacion de caracteristicas
 * sin afectar a la logica enlazada entre
 * Modelo (MimodeloOperacion)-Controlador(CalculadoraController)
 */

package es.iteriam.calculadora.models;

public class MathOperationFactory {

    public MathOperation getOperation(MiModeloOperacion operation) {

        final String operador = operation.getOperador();

        if (operador == null) {
            return null;
        }
        if (operador.equalsIgnoreCase("SUMA")) {
            return new Suma(operation.getA(), operation.getB());

        } else if (operador.equalsIgnoreCase("RESTA")) {
            return new Resta(operation.getA(), operation.getB());

        }
        // Resto de operaciones ampliar aqui para no modificar el Controller
        // .......

        // Resto de operaciones ampliar aqui para no modificar el Controller
        // TO-DO Mejorarlo con mappers en el controller
        System.out.println("No se ha implementado está petición");

        return null;
    }

}
