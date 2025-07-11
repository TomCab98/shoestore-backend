package com.project.shoestore.product.infrastructure.config;

import com.project.shoestore.product.adapters.repositories.BrandRepositoryAdapter;
import com.project.shoestore.product.domain.usecases.CrudBrandService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrandBeansConfig {
  @Bean
  public CrudBrandService crudBrandService(BrandRepositoryAdapter repository) {
    return new CrudBrandService(repository);
  }
}
