package es.iteriam.calculadora.models;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;

public class MiModeloOperacionTest {

    @Autowired
    MiModeloOperacion modelo = new MiModeloOperacion();

    @Test
    public void cargaModel() {
        modelo.setA(new BigDecimal(2));
        modelo.setB(new BigDecimal(2));
        modelo.setOperador("suma");
    }

    // Comprueba que el modelo es correcto
    @Test
    public void testSerialize() throws Exception {
        cargaModel();
        JSONAssert.assertEquals(
                "{a:2, b: 2, operador:\"suma\"}", asJsonString(modelo), JSONCompareMode.LENIENT);
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
