package com.project.shoestore.sales.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record RefundDto(
  String id,

  @NotBlank(message = "product is required")
  String product,

  @NotBlank(message = "sale is required")
  String sale,

  @JsonFormat(pattern = "dd-MM-yyyy")
  @NotNull(message = "date is required")
  Date date,

  String reason
) {}
