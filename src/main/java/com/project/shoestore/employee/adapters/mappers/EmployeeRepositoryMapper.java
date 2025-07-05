package com.project.shoestore.employee.adapters.mappers;

import com.project.shoestore.core.adapters.mappers.RepositoryMapper;
import com.project.shoestore.employee.domain.models.Employee;
import com.project.shoestore.employee.infrastructure.annotations.ToEmployeeEntity;
import com.project.shoestore.employee.infrastructure.repositories.entities.EmployeeEntity;
import com.project.shoestore.employee.infrastructure.repositories.entities.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface EmployeeRepositoryMapper extends RepositoryMapper<Employee, EmployeeEntity> {

  @Named("toRoleList")
  static List<String> toRoleList(Set<RoleEntity> roles) {
    return roles.stream()
      .map(roleEntity -> roleEntity.getRole().name())
      .toList();
  }

  @Override
  @Mapping(target = "roles", source = "roles", qualifiedByName = "toRoleList")
  Employee toDomain(EmployeeEntity entity);

  @Override
  @Mapping(target = "roles", ignore = true)
  @ToEmployeeEntity
  EmployeeEntity toEntity(Employee domain);

  @Mapping(target = "roles", source = "roles")
  @ToEmployeeEntity
  EmployeeEntity toEntity(Employee domain, Set<RoleEntity> roles);
}
