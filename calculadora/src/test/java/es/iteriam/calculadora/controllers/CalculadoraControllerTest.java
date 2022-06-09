package es.iteriam.calculadora.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.assertj.core.api.Assertions;
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

@SpringBootTest
@AutoConfigureMockMvc
public class CalculadoraControllerTest {

	@MockBean
	private MiModeloOperacion mdl;

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("POST /calcula")
	public void suma() throws Exception {

		MiModeloOperacion miOperacion = new MiModeloOperacion(new BigDecimal(2), new BigDecimal(4), "suma");

		MvcResult result = mockMvc.perform(post("/calcula").content(asJsonString(miOperacion))
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andReturn();

		String content = result.getResponse().getContentAsString();

		// Esperamos que 2 + 4 = 6
		Assertions.assertThat(new BigDecimal(content).compareTo(miOperacion.getA().add(miOperacion.getB())));

	}

	private String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
