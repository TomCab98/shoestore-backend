package com.project.shoestore.product.infrastructure.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record CategoryDto(

  @Schema(description = "The ID of the brand", example = "f195d3ce-064f-4bf0-9310-5467a5fe2f79")
  String id,

  @Schema(description = "The name of the category", example = "Zapatillas")
  @NotBlank(message = "The category name cannot be empty")
  String name
) {}
