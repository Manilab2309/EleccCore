/**
 * 
 */
package com.elecc.config;

import java.util.Collections;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import org.slf4j.Logger;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Ramón Cigüenza
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	// Logger
	private final Logger logger = LoggerFactory.getLogger(SwaggerConfiguration.class);

	// Información API
	private static final String title = "API EleccCore";
	private static final String description = "API Services EleccCore";
	private static final String version = "1.0";
	private static final String termsOfServiceUrl = "Software Licence Swagger";
	private static final String license = "@Copyright Ramón Cigüenza Fuster 2018";
	private static final String licenseUrl = "https://swagger.io/";

	// Configuración Básica del API Swagger sin especificar más información
	// @Bean
	// public Docket api() {
	// return new
	// Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
	// .paths(PathSelectors.any()).build();
	//
	// }

	// Configración Personalizada del API Swagger
	@Bean
	public Docket api() {
		logger.debug("-- Application API EleccCore: Cargando Docket de preferencias API");

		// Con Predicates.not especificamos al UI de Swagger que no nos muestre
		// controladores en pantalla que tiene por defecto en la config,
		// actuator, etc... así es más limpio en pantalla
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).build()
				.apiInfo(apiInfo());

	}

	private ApiInfo apiInfo() {

		logger.debug("-- Application API EleccCore: Cargando API info");

		// Detalles del API a mostrar en la página de bienvenida de Swagger-UI
		// 2.0
		ApiInfo apiInfo = new ApiInfo(title, description, version, termsOfServiceUrl,
				new Contact("Ramón Cigüenza Fuster", "https://swagger.io/", "rcifuster@gmail.com"), license, licenseUrl,
				Collections.emptyList());

		return apiInfo;
	}

}
