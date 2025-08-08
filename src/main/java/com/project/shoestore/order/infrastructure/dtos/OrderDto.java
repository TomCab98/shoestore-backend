package com.project.shoestore.order.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Schema(description = "Represents a purchase, which may contain several products")
public record OrderDto(
  String id,

  @JsonFormat(pattern = "dd-MM-yyyy")
  @NotNull(message = "date is required")
  Date date,

  @Schema(description = "The total price of the purchase")
  @NotNull(message = "price is required")
  Float total,

  @Schema(description = "The provider ID")
  @NotNull(message = "provider is required")
  String provider,

  @Schema(description = "It represents the details of the purchase", example = "[{ 'product': 'product1', 'quantity': 2 }]")
  @NotNull(message = "order detail is required")
  List<OrderDetailDto> details
) {}
