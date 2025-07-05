package com.project.shoestore.product.infrastructure.dtos;

import jakarta.validation.constraints.NotBlank;

public record SizeDto(
  @NotBlank(message = "The number of size cannot be empty")
  int size
) {}
