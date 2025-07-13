package com.project.shoestore.client.infrastructure.dtos;

import jakarta.validation.constraints.NotBlank;

public record ClientDto(
  String id,
  String cuit,
  String dni,
  String address,
  Integer phone,

  @NotBlank(message = "Name is required")
  String name,

  @NotBlank(message = "Email is required")
  String email
) {}
