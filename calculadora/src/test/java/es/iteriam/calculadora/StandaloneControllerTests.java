package es.iteriam.calculadora;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import es.iteriam.calculadora.models.MiModeloOperacion;
import es.iteriam.calculadora.servicio.CalculoService;

@SpringBootTest
@AutoConfigureMockMvc
public class StandaloneControllerTests {

	@MockBean
	private CalculoService calculoService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("POST /calcula")
	public void suma() throws Exception {

		MiModeloOperacion miOperacion = new MiModeloOperacion(new BigDecimal(2), new BigDecimal(3));

		mockMvc.perform(post("/calcula?suma")
				.param("miOperacion", "suma")
				.content(asJsonString(miOperacion))
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)				
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				// .andExpect(jsonPath("$.result"))
				.andExpect(status().isOk());

	}

	static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
