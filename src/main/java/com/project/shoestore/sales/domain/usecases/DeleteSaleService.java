package com.project.shoestore.sales.domain.usecases;

import com.project.shoestore.core.domain.usecases.impl.DeleteService;
import com.project.shoestore.sales.domain.models.Sale;
import com.project.shoestore.sales.domain.ports.ISaleRepositoryPort;

public class DeleteSaleService extends DeleteService<Sale, String> {
  public DeleteSaleService(ISaleRepositoryPort repository, FindSaleService findService) {
    super(repository, findService);
  }
}
