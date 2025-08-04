package com.project.shoestore.sales.infrastructure.repositories.entities;

import com.project.shoestore.product.infrastructure.repositories.entities.ProductEntity;
import com.project.shoestore.sales.infrastructure.repositories.ids.SaleDetailId;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sale_detail")
public class SaleDetailEntity {

  @EmbeddedId
  SaleDetailId id;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("saleId")
  @JoinColumn(name = "sale_id")
  SaleEntity sale;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("productId")
  @JoinColumn(name = "product_id")
  ProductEntity product;

  @Column(nullable = false)
  Integer quantity;
}
