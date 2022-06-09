package es.iteriam.calculadora.models;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import es.iteriam.calculadora.utils.Utils;

public class MiModeloOperacionTest {

    private MiModeloOperacion mdl = new MiModeloOperacion();

    @BeforeEach
    public void cargaModel() {
        mdl.setA(new BigDecimal(2));
        mdl.setB(new BigDecimal(2));
        mdl.setOperador("suma");
    }

    // Comprueba que el modelo es correcto
    @Test
    public void testSerialize() throws Exception {
        JSONAssert.assertEquals(
                "{a:2, b: 2, operador:\"suma\"}", Utils.asJsonString(mdl), JSONCompareMode.LENIENT);
    }


}
