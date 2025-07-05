package com.project.shoestore.product.domain.usecases;

import com.project.shoestore.core.domain.usecases.impl.DeleteService;
import com.project.shoestore.product.domain.models.Product;
import com.project.shoestore.product.domain.ports.IProductRepositoryPort;

public class DeleteProductService extends DeleteService<Product, String> {
  public DeleteProductService(IProductRepositoryPort repository, FindProductService findService) {
    super(repository, findService);
  }
}
