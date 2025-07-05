package com.project.shoestore.product.infrastructure.dtos;

import jakarta.validation.constraints.NotBlank;

public record CategoryDto(
  String id,

  @NotBlank(message = "The category name cannot be empty")
  String name
) {}
