package com.example.demo.config;

import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
	
	
	private static final ApiInfo DEFAULT_API_INFO = null;
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = null;
	@Bean
	  public Docket api() {
		System.out.println("Docket bean created");
		return new Docket(DocumentationType.SWAGGER_2).groupName("Star INCEDO").apiInfo(apiInfo()).select()
		.paths(PathSelectors.any()).build();
	  }
	private ApiInfo apiInfo() {
		System.out.println("running api info");
		return new ApiInfoBuilder().title("Book Service")
				.description("Sample Documentation Generateed Using SWAGGER2 for our Book Rest API")
				.termsOfServiceUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ")
				.license("Java_Gyan_Mantra License")
				.licenseUrl("https://www.youtube.com/channel/UCORuRdpN2QTCKnsuEaeK-kQ").version("1.0").build();
	}
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("Running resource handler");
	    registry
	        .addResourceHandler("swagger-ui.html")
	        .addResourceLocations("classpath:/META-INF/resources/");
	    registry
	        .addResourceHandler("/**")
	        .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
