package com.project.shoestore.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.ControllerMapper;
import com.project.shoestore.domain.models.Employee;
import com.project.shoestore.infrastructure.dtos.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeControllerMapper extends ControllerMapper<Employee, EmployeeDto> {
  @Named("setRoles")
  static List<String> setRoles(List<String> roles) {
    return (roles != null) ? roles : Collections.singletonList("EMPLOYEE");
  }

  @Override
  @Mapping(target = "roles", source = "roles", qualifiedByName = "setRoles", defaultExpression = "java(java.util.Collections.singletonList(\"EMPLOYEE\"))")
  Employee toDomain(EmployeeDto dto);
}
