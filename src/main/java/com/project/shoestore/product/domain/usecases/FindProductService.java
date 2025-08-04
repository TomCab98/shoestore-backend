package com.project.shoestore.product.domain.usecases;

import com.project.shoestore.core.domain.exceptions.NotFoundException;
import com.project.shoestore.core.domain.usecases.impl.FindService;
import com.project.shoestore.product.domain.models.Product;
import com.project.shoestore.product.domain.ports.IProductRepositoryPort;

public class FindProductService extends FindService<Product, String> {
  public FindProductService(IProductRepositoryPort repository) {
    super(repository);
  }

  public Product findProductInStockById(String id) {
    Product product = findById(id);
    if (product.getStock() <= 0) {
      throw new NotFoundException("The product " + product.getName() + " is out of stock");
    }

    return product;
  }
}
