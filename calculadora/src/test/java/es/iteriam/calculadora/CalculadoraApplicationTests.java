/**
 * Se prueba si la aplicacion SpringBoot funciona
 */

package es.iteriam.calculadora;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import es.iteriam.calculadora.controllers.CalculadoraController;

@SpringBootTest
class CalculadoraApplicationTests {

	@Autowired
	CalculadoraController calculadoraController;

	@Test
	void contextLoads() {
		assertThat(calculadoraController).isNotNull();
	}

}
