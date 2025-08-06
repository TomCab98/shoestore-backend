package com.project.shoestore.product.infrastructure.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Information for adding stock to product")
public record AddStockRequest(

  @Schema(description = "Number of units to add", example = "50")
  @NotNull(message = "quantity is required")
  Integer quantity
) {}
