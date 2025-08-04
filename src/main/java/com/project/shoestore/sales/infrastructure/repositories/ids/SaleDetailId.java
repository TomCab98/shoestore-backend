package com.project.shoestore.sales.infrastructure.repositories.ids;

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
public class SaleDetailId implements Serializable {
  String productId;
  String saleId;

  public SaleDetailId(String productId) {
    this.productId = productId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SaleDetailId that)) return false;
    return Objects.equals(saleId, that.saleId) &&
      Objects.equals(productId, that.productId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(saleId, productId);
  }
}
