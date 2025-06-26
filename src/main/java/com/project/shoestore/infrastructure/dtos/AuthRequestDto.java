package com.project.shoestore.infrastructure.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthRequestDto(
  @NotBlank String email,
  @NotBlank String password
) {}
