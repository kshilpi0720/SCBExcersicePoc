package com.springboot2.address.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	 @Bean
	    public OpenAPI usersMicroserviceOpenAPI() {
	        return new OpenAPI()
	                .info(new Info().title("Address api docs")
	                                 .description("It provide the services related to address entity")
	                                 .version("1.0"));
	    }
}