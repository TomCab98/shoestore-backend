package com.project.shoestore.core.infrastructure.configurations.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
  @Bean
  public OpenAPI customOpenApi() {
    return new OpenAPI()
      .info(new Info()
        .title("Shoe store management system API")
        .version("1.0")
        .description("This documentation includes all the endpoints of the shoe store management system, including CRUD operations and other more specific endpoints, as well as the schemas that handle them. It is currently in version 1.0, so the documentation will be expanded as new features are developed and implemented.")
      );
  }
}
