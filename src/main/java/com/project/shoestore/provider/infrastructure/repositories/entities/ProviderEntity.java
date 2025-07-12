package com.project.shoestore.provider.infrastructure.repositories.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Providers")
public class ProviderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String id;

  @Column(nullable = false)
  String name;

  @Column(unique = true)
  String dni;

  @Column(unique = true)
  String email;

  String lastName;
  Integer phone;
  String address;
}
