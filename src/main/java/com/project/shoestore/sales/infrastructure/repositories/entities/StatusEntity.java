package com.project.shoestore.sales.infrastructure.repositories.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "`status`")
public class StatusEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(nullable = false, unique = true)
  String name;
}
