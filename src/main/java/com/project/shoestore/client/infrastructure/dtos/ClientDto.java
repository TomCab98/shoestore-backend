package com.project.shoestore.client.infrastructure.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record ClientDto(
  String id,

  @Schema(description = "represents the CUIT number if the customer is a company")
  String cuit,

  @Schema(description = "represents the DNI number if the customer is an individual")
  String dni,
  String address,
  Integer phone,

  @NotBlank(message = "Name is required")
  String name,

  @NotBlank(message = "Email is required")
  String email
) {}
