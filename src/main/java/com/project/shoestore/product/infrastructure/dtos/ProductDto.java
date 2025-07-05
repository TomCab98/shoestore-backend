package com.project.shoestore.product.infrastructure.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductDto(
  String id,
  int minStock,

  @NotBlank(message = "The name cannot be blank")
  @Size(max = 100, min = 3, message = "The product name cannot be longer than 100 characters and less than 3 characters.")
  String name,

  @NotBlank(message = "The amount of stock cannot be empty")
  int stock,

  @NotBlank(message = "The product price cannot be empty")
  int price,

  @NotBlank(message = "The size cannot be empty")
  String size,

  @NotBlank(message = "The product category cannot be empty")
  String category,

  @NotBlank(message = "The product brand cannot be empty")
  String brand
) {}
