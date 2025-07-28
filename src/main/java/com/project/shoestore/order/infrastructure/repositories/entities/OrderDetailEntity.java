package com.project.shoestore.order.infrastructure.repositories.entities;

import com.project.shoestore.product.infrastructure.repositories.entities.ProductEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_detail")
public class OrderDetailEntity {

  @EmbeddedId
  OrderDetailId id = new OrderDetailId();

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("orderId")
  @JoinColumn(name = "order_id")
  private OrderEntity order;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("productId")
  @JoinColumn(name = "product_id")
  ProductEntity product;

  @Column(nullable = false)
  Integer quantity;
}
