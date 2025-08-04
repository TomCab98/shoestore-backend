package com.project.shoestore.sales.domain.usecases;

import com.project.shoestore.core.domain.usecases.impl.FindService;
import com.project.shoestore.sales.domain.models.Sale;
import com.project.shoestore.sales.domain.ports.ISaleRepositoryPort;

public class FindSaleService extends FindService<Sale, String> {
  public FindSaleService(ISaleRepositoryPort repository) {
    super(repository);
  }
}
