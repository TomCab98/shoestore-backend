package com.project.shoestore.order.infrastructure.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Represents the relationship between a product and an order")
public record OrderDetailDto(

  @Schema(description = "The product ID")
  @NotBlank(message = "product is required")
  String product,

  @Schema(description = "The number of products of the same type included in an order", example = "2")
  @NotNull(message = "quantity is required")
  Integer quantity
) {}
