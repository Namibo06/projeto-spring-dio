package com.digitalinnovationone.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot gerado via Spring Initializr
 * Os seguintes módulos foradm selecionados:
 * - Spring Data JPA
 * - Spring Web
 * - MySQL
 * - OpenFeign
 *
 * @author Namibo
 * */

@EnableFeignClients
@SpringBootApplication
public class LabPadroesDeProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesDeProjetoApplication.class, args);
	}

}
