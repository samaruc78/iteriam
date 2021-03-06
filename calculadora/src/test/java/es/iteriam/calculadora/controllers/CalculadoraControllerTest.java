package es.iteriam.calculadora.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import es.iteriam.calculadora.models.MiModeloOperacion;
import es.iteriam.calculadora.utils.Utils;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculadoraControllerTest {

	@MockBean
	private MiModeloOperacion mdl;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void cargaModel() {
		mdl = new MiModeloOperacion(new BigDecimal(2), new BigDecimal(4), "suma");
	}

	@Test
	@DisplayName("POST /calcula")
	public void suma() throws Exception {

		String contentResponse; // El ResponseBody donde tenemos el resultado
		String contentRequest = Utils.asJsonString(mdl);

		MvcResult result = mockMvc.perform(post("/calcula").content(contentRequest)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andReturn();

		contentResponse = result.getResponse().getContentAsString();

		// Esperamos que 2 + 4 = 6
		Assertions.assertThat(new BigDecimal(contentResponse).compareTo(mdl.getA().add(mdl.getB())));

	}

}