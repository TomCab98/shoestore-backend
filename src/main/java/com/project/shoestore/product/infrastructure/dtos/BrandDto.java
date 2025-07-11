package com.project.shoestore.product.infrastructure.dtos;

import jakarta.validation.constraints.NotBlank;

public record BrandDto(
  String id,

  @NotBlank(message = "The brand name cannot be empty")
  String name
) {}
