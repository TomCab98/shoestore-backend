package com.project.shoestore.product.infrastructure.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "size")
public class SizeEntity {
  @Id
  private String number;
}

