package com.project.shoestore.sales.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Schema(description = "Represents a sale, which may contain several products")
public record SaleDto(
  String id,
  String status,

  @JsonFormat(pattern = "dd-MM-yyyy")
  @NotNull(message = "date is required")
  Date date,

  @Schema(description = "The total price of the sale")
  @NotNull(message = "price is required")
  Float total,

  @Schema(description = "The client ID")
  @NotNull(message = "client is required")
  String client,

  @Schema(description = "The employee ID")
  @NotNull(message = "employee is required")
  String employee,

  @Schema(description = "It represents the details of the sale", example = "[{ 'product': 'product1', 'quantity': 2 }]")
  @NotNull(message = "order detail is required")
  List<SaleDetailDto> details
) {}
