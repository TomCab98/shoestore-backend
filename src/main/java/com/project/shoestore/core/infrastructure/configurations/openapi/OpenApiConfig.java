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
        .title("Shoe store system API")
        .version("1.0")
        .description("Documentation for the shoe store management system")
      );
  }
}
