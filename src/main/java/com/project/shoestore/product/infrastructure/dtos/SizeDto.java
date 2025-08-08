package com.project.shoestore.product.infrastructure.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record SizeDto(

  @Schema(description = "The number of the size", example = "40")
  @NotNull(message = "The number of size is required")
  Integer size
) {}
