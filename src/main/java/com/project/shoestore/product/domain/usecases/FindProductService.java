package com.project.shoestore.product.domain.usecases;

import com.project.shoestore.core.domain.usecases.impl.FindService;
import com.project.shoestore.product.domain.models.Product;
import com.project.shoestore.product.domain.ports.IProductRepositoryPort;

public class FindProductService extends FindService<Product, String> {
  public FindProductService(IProductRepositoryPort repository) {
    super(repository);
  }
}
