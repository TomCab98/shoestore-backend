package com.project.shoestore.sales.infrastructure.config;

import com.project.shoestore.product.domain.usecases.FindProductService;
import com.project.shoestore.product.domain.usecases.UpdateProductService;
import com.project.shoestore.sales.adapters.repositories.SaleRepositoryAdapter;
import com.project.shoestore.sales.domain.ports.ISaleRepositoryPort;
import com.project.shoestore.sales.domain.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaleBeansConfig {
  @Bean
  public CreateSaleService createSaleService(SaleRepositoryAdapter repository) {
    return new CreateSaleService(repository);
  }

  @Bean
  public UpdateSaleService updateSaleService(SaleRepositoryAdapter repository) {
    return new UpdateSaleService(repository);
  }

  @Bean
  public DeleteSaleService deleteSaleService(SaleRepositoryAdapter repository, FindSaleService findSaleService) {
    return new DeleteSaleService(repository, findSaleService);
  }

  @Bean
  public FindSaleService findSaleService(SaleRepositoryAdapter repository) {
    return new FindSaleService(repository);
  }

  @Bean
  public RefundProductService refundProductService(
    ISaleRepositoryPort repository,
    UpdateProductService updateProductService,
    FindProductService findProductService
  ) {
    return new RefundProductService(repository, updateProductService, findProductService);
  }
}
