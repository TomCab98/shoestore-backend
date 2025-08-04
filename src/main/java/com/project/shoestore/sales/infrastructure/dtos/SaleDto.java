package com.project.shoestore.sales.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public record SaleDto(
  String id,

  @JsonFormat(pattern = "dd-MM-yyyy")
  @NotNull(message = "date is required")
  Date date,

  @NotNull(message = "price is required")
  Float total,

  @NotNull(message = "client is required")
  String client,

  @NotNull(message = "employee is required")
  String employee,

  @NotNull(message = "order detail is required")
  List<SaleDetailDto> details
) {}
