package com.project.shoestore.provider.infrastructure.dtos;

import jakarta.validation.constraints.NotBlank;

public record ProviderDto(
  String id,
  String dni,
  String lastName,
  Integer phone,
  String address,
  String email,

  @NotBlank(message = "Name is required")
  String name
) {}
