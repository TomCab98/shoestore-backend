package com.project.shoestore.product.infrastructure.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "size")
public class SizeEntity {
  @Id
  private int size;
}

