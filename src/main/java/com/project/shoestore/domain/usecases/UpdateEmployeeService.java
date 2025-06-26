package com.project.shoestore.domain.usecases;

import com.project.shoestore.core.domain.usecases.impl.UpdateService;
import com.project.shoestore.domain.models.Employee;
import com.project.shoestore.domain.ports.IEmployeeRepositoryPort;

public class UpdateEmployeeService extends UpdateService<Employee, String> {
  public UpdateEmployeeService(IEmployeeRepositoryPort repository) {
    super(repository);
  }
}
