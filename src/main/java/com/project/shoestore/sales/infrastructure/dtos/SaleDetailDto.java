package com.project.shoestore.sales.infrastructure.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Represents the relationship between a product and a sale")
public record SaleDetailDto(

  @Schema(description = "The product ID")
  @NotBlank(message = "product is required")
  String product,

  @Schema(description = "The number of products of the same type included in a sale", example = "2")
  @NotNull(message = "quantity is required")
  Integer quantity
) {}
