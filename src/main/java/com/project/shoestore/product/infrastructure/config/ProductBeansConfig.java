package com.project.shoestore.product.infrastructure.config;

import com.project.shoestore.product.adapters.repositories.ProductRepositoryAdapter;
import com.project.shoestore.product.domain.usecases.CreateProductService;
import com.project.shoestore.product.domain.usecases.DeleteProductService;
import com.project.shoestore.product.domain.usecases.FindProductService;
import com.project.shoestore.product.domain.usecases.UpdateProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductBeansConfig {
  @Bean
  public CreateProductService createProductService(ProductRepositoryAdapter repository) {
    return new CreateProductService(repository);
  }

  @Bean
  public UpdateProductService updateProductService(ProductRepositoryAdapter repository) {
    return new UpdateProductService(repository);
  }

  @Bean
  public DeleteProductService deleteProductService(ProductRepositoryAdapter repository, FindProductService findProductService) {
    return new DeleteProductService(repository, findProductService);
  }

  @Bean
  public FindProductService findProductService(ProductRepositoryAdapter repository) {
    return new FindProductService(repository);
  }
}
