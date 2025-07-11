package com.project.shoestore.product.infrastructure.config;

import com.project.shoestore.product.adapters.repositories.CategoryRepositoryAdapter;
import com.project.shoestore.product.domain.usecases.CrudCategoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryBeansConfig {
  @Bean
  public CrudCategoryService crudCategoryService(CategoryRepositoryAdapter repository) {
    return new CrudCategoryService(repository);
  }
}
