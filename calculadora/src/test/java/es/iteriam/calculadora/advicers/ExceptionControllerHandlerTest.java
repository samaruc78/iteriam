package es.iteriam.calculadora.advicers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.util.Assert;

import es.iteriam.calculadora.models.MiModeloOperacion;
import es.iteriam.calculadora.utils.Utils;
import io.corp.calculator.TracerImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class ExceptionControllerHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TracerImpl tr;

    private BigDecimal operando1;
    private BigDecimal operando2;
    private String operador;

    private MiModeloOperacion mdl;

    /**
     * se prueba si este metodo maneja la exception correspondiente.
     * En este caso para un operador que no se tiene implementado
     * ha de responder un estado NOT_IMPLEMENTED y
     * una execpcion de tipo InvalidOperationException
     * 
     * @throws Exception
     */
    @Test
    public void testNoExisteOperacion() throws Exception {

        // Es un requestBody cuya propiedad operador no esta implementada.
        this.operando1 = new BigDecimal(1);
        this.operando2 = new BigDecimal(2);
        this.operador = "noTengoOperacion"; // i
        this.mdl = new MiModeloOperacion(operando1, operando2, operador);

        String contentRequest = Utils.asJsonString(mdl); // El Request que se manda en formato JSON
        MvcResult contentResponse = // El Response segun Request
                mockMvc.perform(post("/calcula").content(contentRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(status().isNotImplemented())
                        .andReturn();

        Assert.isInstanceOf(InvalidOperationException.class, contentResponse.getResolvedException());
        tr.trace(contentResponse);
    }

    /**
     * se prueba si este metodo maneja la exception correspondiente.
     * En este caso para un request que no se ajusta al modelo MiModeloOperacion
     * ha de responder un estado BAD_REQUEST y
     * una execpcion de tipo InvalidOperationException
     * 
     * @throws Exception
     */
    @Test
    public void testBadRequest() throws Exception {

        // Es un requestBody que no se corresponde con el modelo MiModeloOperacion
        // Por ejemplo un simple string

        String contentRequest = "Request mal serializado";
        MvcResult contentResponse = // El Response segun Request
                mockMvc.perform(post("/calcula").content(contentRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(status().isBadRequest())
                        .andReturn();

        Assert.isInstanceOf(HttpMessageNotReadableException.class, contentResponse.getResolvedException());
        tr.trace(contentResponse);
    }

    /**
     * se prueba si este metodo maneja la exception correspondiente.
     * En este caso para un request con divisor = 0
     * ha de responder un estado BAD_REQUEST y
     * una execpcion de tipo ArithmeticException
     * 
     * @throws Exception
     */
    @Test
    public void testDivisionCero() throws Exception {

        this.operando1 = new BigDecimal(1);
        this.operando2 = new BigDecimal(0); // Se fuerza valor a 0 
        this.operador = "division";
        
        this.mdl = new MiModeloOperacion(operando1, operando2, operador);
        
        // Confirmamos que estamos realizando una division y que el divisor es 0
        Assertions.assertTrue(mdl.getOperador().equalsIgnoreCase("DIVISION"), "No es una división");
        Assertions.assertTrue(mdl.getB().compareTo(new BigDecimal(0))==0, "No es un divisor igual a 0");
        
        String contentRequest = Utils.asJsonString(mdl);
        MvcResult contentResponse = // El Response segun Request
                mockMvc.perform(post("/calcula").content(contentRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(status().isBadRequest())
                        .andReturn();

        Assert.isInstanceOf(ArithmeticException.class, contentResponse.getResolvedException());
        tr.trace(contentResponse);
    }

}
