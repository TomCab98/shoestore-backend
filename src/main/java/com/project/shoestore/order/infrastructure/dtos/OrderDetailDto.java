package com.project.shoestore.order.infrastructure.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderDetailDto(

  @NotBlank(message = "product is required")
  String product,

  @NotNull(message = "quantity is required")
  Integer quantity
) {}
