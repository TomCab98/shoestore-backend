package com.project.shoestore.client.infrastructure.config;

import com.project.shoestore.client.adapters.repositories.ClientRepositoryAdapter;
import com.project.shoestore.client.domain.usecases.CrudClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientBeansConfig {
  @Bean
  public CrudClientService crudClientService(ClientRepositoryAdapter repository) {
    return new CrudClientService(repository);
  }
}
