package es.iteriam.calculadora.servicio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import es.iteriam.calculadora.controllers.MathOperationFactory;
import es.iteriam.calculadora.controllers.Suma;
import es.iteriam.calculadora.models.MiModeloOperacion;

public class CalculoServiceTest {

    @Autowired
    MathOperationFactory operacionFactory = new MathOperationFactory();

    @Autowired
    MiModeloOperacion mdl = new MiModeloOperacion("suma");

    @Test
    public void factoryTest() {

        Object o = operacionFactory.getOperation(mdl);
        Assert.isTrue(o instanceof Suma, "OK");

    }

}
