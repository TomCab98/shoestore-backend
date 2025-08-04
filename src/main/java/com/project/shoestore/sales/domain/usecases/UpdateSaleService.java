package com.project.shoestore.sales.domain.usecases;

import com.project.shoestore.core.domain.usecases.impl.UpdateService;
import com.project.shoestore.sales.domain.models.Sale;
import com.project.shoestore.sales.domain.ports.ISaleRepositoryPort;

public class UpdateSaleService extends UpdateService<Sale, String> {
  public UpdateSaleService(ISaleRepositoryPort repository) {
    super(repository);
  }
}
