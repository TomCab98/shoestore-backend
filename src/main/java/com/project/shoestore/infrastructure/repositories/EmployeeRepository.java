package com.project.shoestore.infrastructure.repositories;

import com.project.shoestore.core.infrastructure.repositories.IRepository;
import com.project.shoestore.infrastructure.repositories.entities.EmployeeEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends IRepository<EmployeeEntity, String> {
  Optional<EmployeeEntity> findEmployeeEntityByEmail(String email);
}
