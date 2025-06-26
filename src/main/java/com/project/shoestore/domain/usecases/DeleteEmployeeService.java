package com.project.shoestore.domain.usecases;

import com.project.shoestore.core.domain.usecases.impl.DeleteService;
import com.project.shoestore.domain.models.Employee;
import com.project.shoestore.domain.ports.IEmployeeRepositoryPort;

public class DeleteEmployeeService extends DeleteService<Employee, String> {
  public DeleteEmployeeService(IEmployeeRepositoryPort repository, FindEmployeeService findService) {
    super(repository, findService);
  }
}
