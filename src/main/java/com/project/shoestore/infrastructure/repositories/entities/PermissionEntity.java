package com.project.shoestore.infrastructure.repositories.entities;

import com.project.shoestore.infrastructure.dtos.PermissionEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "`permissions`")
public class PermissionEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(name = "permission_name", unique = true, nullable = false, updatable = false)
  @Enumerated(EnumType.STRING)
  private PermissionEnum permission;
}
