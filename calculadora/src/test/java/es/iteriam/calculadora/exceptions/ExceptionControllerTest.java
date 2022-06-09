package es.iteriam.calculadora.exceptions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;


@SpringBootTest
@AutoConfigureMockMvc
public class ExceptionControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testExcepcion() {

    }

    /**
     * se prueba si este metodo maneja la exception correspondiente.
     * En este caso al ser un BAD_REQUEST ha de lanzar una excepcion
     * tipo InputParamException
     * @throws Exception
     */
    @Test
    public void inputRequestBody() throws Exception {
		String contentResponse; // El ResponseBody donde tenemos el resultado
		String contentRequest = "random";

		MvcResult result = mockMvc.perform(post("/calcula").content(contentRequest)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isBadRequest())
				.andReturn();

        if (result.getResolvedException() instanceof InputParamException) {
            Assertions.assertThat(true);
        } else {
            Assertions.assertThat(false);
        }
            
    }

}
