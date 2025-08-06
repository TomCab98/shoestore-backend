package com.project.shoestore.product.infrastructure.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "DTO representing a brand in the shoe store")
public record BrandDto(

  @Schema(description = "Unique identifier of the brand", example = "f195d3ce-064f-4bf0-9310-5467a5fe2f79")
  String id,

  @Schema(description = "The name of the brand", example = "Dior")
  @NotBlank(message = "The brand name cannot be empty")
  String name
) {}
