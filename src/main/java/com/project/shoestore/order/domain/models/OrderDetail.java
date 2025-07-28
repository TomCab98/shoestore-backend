package com.project.shoestore.order.domain.models;

import com.project.shoestore.product.domain.models.Product;

public class OrderDetail {
  Product product;
  Integer quantity;

  public OrderDetail() {}

  public OrderDetail(Product product, Integer quantity) {
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
}
