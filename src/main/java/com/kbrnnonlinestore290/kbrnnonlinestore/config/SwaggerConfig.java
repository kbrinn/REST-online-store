package com.kbrnnonlinestore290.kbrnnonlinestore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * SwaggerConfig.java to automate the generation of Swagger documentation for the API.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final String NAME = "Kevin B";
    public static final String URL = "https://github.com/kbrinn";
    public static final String EMAIL = "fredckbrr@gmail.com";
    @Bean
    public Docket Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.example.controllers"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        Contact contact = new Contact(NAME, URL, EMAIL);
        return new ApiInfoBuilder()
                .title("Spring Boot REST API")
                .description("Spring Boot REST API for a simple e-commerce application")
                .version("1.0.0")
                .contact(contact)
                .build();
    }
}
