package es.iteriam.calculadora.models;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

import io.corp.calculator.TracerImpl;

@SpringBootTest
public class MathOperationTest {

    private MathOperationFactory operacionFactory = new MathOperationFactory();
    private MathOperation operacion;
    private MiModeloOperacion mdl = new MiModeloOperacion();

    @Autowired
    private TracerImpl tr;

    @BeforeEach
    public void cargaModel() {                
        mdl.setA(new BigDecimal(2));
        mdl.setB(new BigDecimal(4));
        // mdl.setB(new BigDecimal(0));  // Probar division por cero
    }

    @Test
    public void suma() {
        mdl.setOperador("sUmA");
    }

    @Test
    public void resta() {
        mdl.setOperador("ResTa");
    }

    @Test
    public void division() {
        mdl.setOperador("dIvISIoN");

        if (mdl.getB().intValue() == 0) {
            AssertionErrors.fail("Division por cero");
        }

    }

    @AfterEach
    public void calcula() {
        operacion = operacionFactory.getOperation(mdl);
        BigDecimal x = operacion.calculate();
        tr.trace(x);
        Assertions.assertThat(x.equals(mdl.getA().add(mdl.getB())));
    }

}
