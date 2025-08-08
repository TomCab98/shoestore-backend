package com.project.shoestore.product.infrastructure.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductDto(

  @Schema(description = "The ID of the product", example = "f195d3ce-064f-4bf0-9310-5467a5fe2f79")
  String id,

  @Schema(description = "Minimum stock before triggering alert", example = "5")
  Integer minStock,

  @NotBlank(message = "The name cannot be blank")
  @Size(max = 100, min = 3, message = "The product name cannot be longer than 100 characters and less than 3 characters.")
  String name,

  @NotNull(message = "The amount of stock is required")
  @Schema(description = "Current stock quantity", example = "20")
  Integer stock,

  @NotNull(message = "The product price is required")
  @Schema(description = "Unit price of the product", example = "34999.99")
  Float price,

  @NotNull(message = "The size is required")
  @Schema(description = "The size ID", example = "42")
  Integer size,

  @NotBlank(message = "The product category is required")
  @Schema(description = "The category ID")
  String category,

  @NotBlank(message = "The product brand is required")
  @Schema(description = "The brand ID")
  String brand
) {}
