package com.project.shoestore.product.infrastructure.dtos;

import jakarta.validation.constraints.NotNull;

public record SizeDto(
  @NotNull(message = "The number of size is required")
  Integer size
) {}
