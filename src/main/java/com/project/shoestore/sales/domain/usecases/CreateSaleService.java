package com.project.shoestore.sales.domain.usecases;

import com.project.shoestore.core.domain.usecases.impl.CreateService;
import com.project.shoestore.sales.domain.models.Sale;
import com.project.shoestore.sales.domain.ports.ISaleRepositoryPort;

public class CreateSaleService extends CreateService<Sale, String> {
  public CreateSaleService(ISaleRepositoryPort repository) {
    super(repository);
  }
}
