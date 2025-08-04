package com.project.shoestore.sales.infrastructure.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SaleDetailDto(

  @NotBlank(message = "product is required")
  String product,

  @NotNull(message = "quantity is required")
  Integer quantity
) {}
