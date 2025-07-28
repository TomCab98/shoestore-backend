package com.project.shoestore.order.infrastructure.repositories.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailId implements Serializable {
  String productId;
  String orderId;

  public OrderDetailId(String productId) {
    this.productId = productId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof OrderDetailId that)) return false;
    return Objects.equals(orderId, that.orderId) &&
      Objects.equals(productId, that.productId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, productId);
  }
}
