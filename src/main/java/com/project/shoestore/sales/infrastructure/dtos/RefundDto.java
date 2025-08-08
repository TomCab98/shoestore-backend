package com.project.shoestore.sales.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Schema(description = "Represents a request for change or refund")
public record RefundDto(
  String id,
  String reason,
  String status,

  @Schema(description = "The product ID")
  @NotBlank(message = "product is required")
  String product,

  @Schema(description = "The sale ID")
  @NotBlank(message = "sale is required")
  String sale,

  @JsonFormat(pattern = "dd-MM-yyyy")
  @NotNull(message = "date is required")
  Date date
) {}
