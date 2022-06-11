package es.iteriam.calculadora.advicers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.corp.calculator.TracerImpl;

@Configuration
public class TracerImplConfig {

    @Bean
	public TracerImpl miBean() {
		return new TracerImpl();
	}
    
}
