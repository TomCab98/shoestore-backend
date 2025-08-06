package com.project.shoestore.product.infrastructure.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "DTO representing a size in the shoe store")
public record SizeDto(

  @Schema(description = "The name of the size", example = "40")
  @NotNull(message = "The number of size is required")
  Integer size
) {}
