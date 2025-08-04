package com.project.shoestore.sales.domain.models;

import com.project.shoestore.product.domain.models.Product;

public class SaleDetail {
  Product product;
  Integer quantity;

  public SaleDetail() {}

  public SaleDetail(Product product, Integer quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "SaleDetail { product = " + product + ", quantity = " + quantity + " }";
  }
}
