package com.project.shoestore.product.domain.usecases;

import com.project.shoestore.core.domain.usecases.impl.CreateService;
import com.project.shoestore.product.domain.models.Product;
import com.project.shoestore.product.domain.ports.IProductRepositoryPort;

public class CreateProductService extends CreateService<Product, String> {
  public CreateProductService(IProductRepositoryPort repository) {
    super(repository);
  }
}
