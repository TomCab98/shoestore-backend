package com.project.shoestore.order.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public record OrderDto(
  String id,

  @JsonFormat(pattern = "dd-MM-yyyy")
  @NotNull(message = "date is required")
  Date date,

  @NotNull(message = "price is required")
  Float total,

  @NotNull(message = "provider is required")
  String provider,

  @NotNull(message = "order detail is required")
  List<OrderDetailDto> details
) {}
