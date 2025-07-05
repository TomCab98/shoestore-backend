package com.project.shoestore.product.infrastructure.repositories.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "brand")
public class BrandEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;
  private String name;
}

