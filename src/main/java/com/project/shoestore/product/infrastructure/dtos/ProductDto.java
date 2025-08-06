package com.project.shoestore.product.infrastructure.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "DTO representing a product in the shoe store")
public record ProductDto(

  @Schema(description = "Unique identifier of the product", example = "f195d3ce-064f-4bf0-9310-5467a5fe2f79")
  String id,

  @Schema(description = "Minimum stock before triggering alert", example = "5")
  Integer minStock,

  @NotBlank(message = "The name cannot be blank")
  @Size(max = 100, min = 3, message = "The product name cannot be longer than 100 characters and less than 3 characters.")
  @Schema(description = "Name of the product", example = "Zapatilla deportiva Nike")
  String name,

  @NotNull(message = "The amount of stock is required")
  @Schema(description = "Current stock quantity", example = "20")
  Integer stock,

  @NotNull(message = "The product price is required")
  @Schema(description = "Unit price of the product", example = "34999.99")
  Float price,

  @NotNull(message = "The size is required")
  @Schema(description = "Shoe size", example = "42")
  Integer size,

  @NotBlank(message = "The product category is required")
  @Schema(description = "Product category (e.g., Casual, Deportivo, Elegante)", example = "Deportivo")
  String category,

  @NotBlank(message = "The product brand is required")
  @Schema(description = "Brand of the product", example = "Nike")
  String brand

) {}
