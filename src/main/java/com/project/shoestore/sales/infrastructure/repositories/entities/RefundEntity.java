package com.project.shoestore.sales.infrastructure.repositories.entities;

import com.project.shoestore.sales.infrastructure.repositories.ids.SaleDetailId;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "refund")
public class  RefundEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String id;

  String reason;

  @Column(nullable = false)
  Date date;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumns({
    @JoinColumn(name = "sale_id", referencedColumnName = "sale_id"),
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
  })
  SaleDetailEntity detail;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
  private StatusEntity status;
}
