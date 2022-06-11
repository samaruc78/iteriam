package es.iteriam.calculadora.models;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.iteriam.calculadora.utils.Utils;
import io.corp.calculator.TracerImpl;

@SpringBootTest
public class MiModeloOperacionTest {

    @Autowired
    private TracerImpl tr;

    private BigDecimal operando1;
    private BigDecimal operando2;
    private String operador;

    private MiModeloOperacion mdl = new MiModeloOperacion();

    @BeforeEach
    public void cargaModel() {

        // mi input para test. Cambiar valor para mas tests.
        this.operando1 = new BigDecimal(1);
        this.operando2 = new BigDecimal(2);
        this.operador = "sUmA";
    }

    // Comprueba que el modelo es correcto
    @Test
    public void testSerialize() throws Exception {

        mdl.setA(operando1);
        mdl.setB(operando2);
        mdl.setOperador(operador);

        String rstdo = Utils.asJsonString(mdl);
        JSONAssert.assertEquals(
                "{ " +
                        "a: " + String.valueOf(this.operando1) + ", " +
                        "b: " + String.valueOf(this.operando2) + ", " +
                        "operador: " + this.operador +
                        " }",
                rstdo, JSONCompareMode.LENIENT);
        tr.trace(rstdo);
    }

}
