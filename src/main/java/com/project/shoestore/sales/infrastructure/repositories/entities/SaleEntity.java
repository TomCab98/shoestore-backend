package com.project.shoestore.sales.infrastructure.repositories.entities;

import com.project.shoestore.client.infrastructure.repositories.entities.ClientEntity;
import com.project.shoestore.employee.infrastructure.repositories.entities.EmployeeEntity;
import com.project.shoestore.order.infrastructure.repositories.entities.OrderDetailEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "sale")
public class SaleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String id;

  @Column(nullable = false)
  Date date;

  @Column(nullable = false)
  Float total;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id", nullable = false)
  EmployeeEntity employee;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "client_id", nullable = false)
  ClientEntity client;

  @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
  List<SaleDetailEntity> details = new ArrayList<>();

  public void addDetails(SaleDetailEntity detail) {
    detail.setSale(this);
    this.details.add(detail);
  }
}
