package com.project.shoestore.product.infrastructure.config;

import com.project.shoestore.product.adapters.repositories.SizeRepositoryAdapter;
import com.project.shoestore.product.domain.usecases.CrudSizeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SizeBeansConfig {
  @Bean
  public CrudSizeService crudSizeService(SizeRepositoryAdapter repository) {
    return new CrudSizeService(repository);
  }
}