package com.project.shoestore.employee.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"email", "message", "jwt", "status"})
public record AuthResponseDto(
  String email,
  String message,
  String jwt,
  boolean status
) {}
