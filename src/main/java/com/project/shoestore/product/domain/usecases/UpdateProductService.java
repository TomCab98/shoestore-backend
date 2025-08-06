package com.project.shoestore.product.domain.usecases;

import com.project.shoestore.core.domain.exceptions.NotFoundException;
import com.project.shoestore.core.domain.usecases.impl.UpdateService;
import com.project.shoestore.product.domain.models.Product;
import com.project.shoestore.product.domain.ports.IProductRepositoryPort;

public class UpdateProductService extends UpdateService<Product, String> {
  public UpdateProductService(IProductRepositoryPort repository) {
    super(repository);
  }

  public Product addStock(String productId, int quantity) {
    Product product = repository.findById(productId)
      .orElseThrow(() -> new NotFoundException("Not found product"));

    int stock = product.getStock() + quantity;
    product.setStock(stock);

    return repository.create(product);
  }
}
