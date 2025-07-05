package com.project.shoestore.product.infrastructure.repositories.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String name;
}
