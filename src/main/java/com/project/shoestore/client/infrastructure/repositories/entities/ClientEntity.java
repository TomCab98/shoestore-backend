package com.project.shoestore.client.infrastructure.repositories.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class ClientEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String id;

  @Column(unique = true)
  String email;

  @Column(unique = true)
  String cuit;

  @Column(unique = true)
  String dni;

  String name;
  String address;
  Integer phone;

}
