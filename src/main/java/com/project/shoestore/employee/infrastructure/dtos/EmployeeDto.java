package com.project.shoestore.employee.infrastructure.dtos;

import com.project.shoestore.employee.infrastructure.dtos.validations.ValidateRoleList;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public record EmployeeDto(
  String id,
  String address,
  String lastName,
  int phone,

  @NotBlank(message = "The name cannot be blank")
  @Size(max = 100, min = 3, message = "The name cannot be longer than 100 characters and less than 3 characters.")
  String name,

  @NotNull(message = "The date cannot be null")
  @Size(max = 100, min = 3, message = "Password not valid")
  String password,

  @NotNull(message = "The password cannot be null")
  @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Not valid email")
  String email,

  @NotBlank(message = "DNI cannot be blank")
  @Size(max = 100, min = 3, message = "DNI cannot be longer than 100 characters and less than 3 characters.")
  String dni,

  @ValidateRoleList
  List<String> roles
) {}
