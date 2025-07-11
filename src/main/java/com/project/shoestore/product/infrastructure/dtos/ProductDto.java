package com.project.shoestore.product.infrastructure.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProductDto(
  String id,
  Integer minStock,

  @NotBlank(message = "The name cannot be blank")
  @Size(max = 100, min = 3, message = "The product name cannot be longer than 100 characters and less than 3 characters.")
  String name,

  @NotNull(message = "The amount of stock is required")
  Integer stock,

  @NotNull(message = "The product price is required")
  Float price,

  @NotNull(message = "The size is required")
  Integer size,

  @NotBlank(message = "The product category is required")
  String category,

  @NotBlank(message = "The product brand is required")
  String brand
) {}
