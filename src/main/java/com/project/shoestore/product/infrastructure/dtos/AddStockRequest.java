package com.project.shoestore.product.infrastructure.dtos;

import jakarta.validation.constraints.NotNull;

public record AddStockRequest(

  @NotNull(message = "quantity is required")
  Integer quantity
) {}
