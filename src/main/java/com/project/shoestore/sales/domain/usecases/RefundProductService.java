package com.project.shoestore.sales.domain.usecases;

import com.project.shoestore.product.domain.models.Product;
import com.project.shoestore.product.domain.usecases.FindProductService;
import com.project.shoestore.product.domain.usecases.UpdateProductService;
import com.project.shoestore.sales.domain.models.Refund;
import com.project.shoestore.sales.domain.ports.ISaleRepositoryPort;

public class RefundProductService {
  private final ISaleRepositoryPort repository;
  private final FindProductService findProductService;
  private final UpdateProductService updateProductService;

  public RefundProductService(
    ISaleRepositoryPort repository,
    UpdateProductService updateProductService,
    FindProductService findProductService
  ) {
    this.repository = repository;
    this.updateProductService = updateProductService;
    this.findProductService = findProductService;
  }

  public void refund(Refund refund) {
    repository.refundProduct(refund);
    Product product = findProductService.findProductInStockById(refund.getProduct());
    int stock = product.getStock() - 1;
    product.setStock(stock);

    updateProductService.update(product.getId(), product);
  }
}
