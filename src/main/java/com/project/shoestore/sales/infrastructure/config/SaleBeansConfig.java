package com.project.shoestore.sales.infrastructure.config;

import com.project.shoestore.sales.adapters.repositories.SaleRepositoryAdapter;
import com.project.shoestore.sales.domain.usecases.CreateSaleService;
import com.project.shoestore.sales.domain.usecases.DeleteSaleService;
import com.project.shoestore.sales.domain.usecases.FindSaleService;
import com.project.shoestore.sales.domain.usecases.UpdateSaleService;
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
}
