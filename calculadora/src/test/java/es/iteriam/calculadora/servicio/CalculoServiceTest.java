package es.iteriam.calculadora.servicio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import es.iteriam.calculadora.models.MathOperationFactory;
import es.iteriam.calculadora.models.MiModeloOperacion;
import es.iteriam.calculadora.models.Suma;

public class CalculoServiceTest {

    @Autowired
    private MathOperationFactory operacionFactory = new MathOperationFactory();

    @Autowired
    private MiModeloOperacion mdl = new MiModeloOperacion("suma");

    @Test
    public void factoryTest() {

        Object o = operacionFactory.getOperation(mdl);
        Assert.isTrue(o instanceof Suma, "OK");

    }

}
