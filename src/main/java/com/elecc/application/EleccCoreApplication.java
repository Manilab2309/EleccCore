package com.elecc.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.elecc.config.SwaggerConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Ramón Cigüenza
 *
 */

@ComponentScan("com.elecc.*")

@EntityScan(basePackages = "com.elecc.entity")

@SpringBootApplication
@EnableSwagger2
@Import(SwaggerConfiguration.class)
public class EleccCoreApplication {

	private static final Logger logger = LoggerFactory.getLogger(EleccCoreApplication.class);
	
	public static void main(String[] args) {

		// La ejecución comienza aquí
		SpringApplication.run(EleccCoreApplication.class, args);

		logger.debug("-- Application API EleccCore Started --");
	}
}
