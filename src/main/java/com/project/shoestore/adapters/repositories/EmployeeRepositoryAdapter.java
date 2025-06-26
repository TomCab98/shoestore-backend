package com.project.shoestore.adapters.repositories;

import com.project.shoestore.adapters.mappers.EmployeeRepositoryMapper;
import com.project.shoestore.core.adapters.repositories.RepositoryAdapter;
import com.project.shoestore.core.domain.exceptions.NotFoundException;
import com.project.shoestore.domain.models.Employee;
import com.project.shoestore.domain.ports.IEmployeeRepositoryPort;
import com.project.shoestore.infrastructure.repositories.EmployeeRepository;
import com.project.shoestore.infrastructure.repositories.RoleRepository;
import com.project.shoestore.infrastructure.repositories.entities.EmployeeEntity;
import com.project.shoestore.infrastructure.repositories.entities.RoleEntity;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class EmployeeRepositoryAdapter extends RepositoryAdapter<Employee, EmployeeEntity, String> implements IEmployeeRepositoryPort {
  private final RoleRepository roleRepository;
  private final EmployeeRepositoryMapper mapper;
  private final EmployeeRepository repository;

  public EmployeeRepositoryAdapter(
    EmployeeRepository repository,
    EmployeeRepositoryMapper mapper,
    RoleRepository roleRepository
  ) {
    super(repository, mapper);
    this.repository =  repository;
    this.roleRepository = roleRepository;
    this.mapper = mapper;
  }

  @Override
  public Employee create(Employee domain) {
    Set<RoleEntity> roles = roleRepository.findByRoleIn(domain.getRoles());
    if (roles.isEmpty()) {
      throw new NotFoundException("not found roles in database: " + roles);
    }

    EmployeeEntity entity = mapper.toEntity(domain, roles);
    EmployeeEntity created = repository.save(entity);
    return mapper.toDomain(created);
  }
}
