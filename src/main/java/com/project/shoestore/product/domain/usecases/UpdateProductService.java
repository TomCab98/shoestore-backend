package com.project.shoestore.product.domain.usecases;

import com.project.shoestore.core.domain.usecases.impl.UpdateService;
import com.project.shoestore.product.domain.models.Product;
import com.project.shoestore.product.domain.ports.IProductRepositoryPort;

public class UpdateProductService extends UpdateService<Product, String> {
  public UpdateProductService(IProductRepositoryPort repository) {
    super(repository);
  }
}
