package com.project.shoestore.order.infrastructure.repositories.entities;

import com.project.shoestore.provider.infrastructure.repositories.entities.ProviderEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "`order`")
public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String id;

  @Column(nullable = false)
  Date date;

  @Column(nullable = false)
  Float total;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "provider_id", nullable = false)
  ProviderEntity provider;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
  List<OrderDetailEntity> details = new ArrayList<>();

  public void addDetails(OrderDetailEntity detail) {
    detail.setOrder(this);
    this.details.add(detail);
  }
}
