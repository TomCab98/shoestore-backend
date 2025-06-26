package com.project.shoestore.domain.usecases;

import com.project.shoestore.core.domain.usecases.impl.FindService;
import com.project.shoestore.domain.models.Employee;
import com.project.shoestore.domain.ports.IEmployeeRepositoryPort;

public class FindEmployeeService extends FindService<Employee, String> {
  public FindEmployeeService(IEmployeeRepositoryPort repository) {
    super(repository);
  }
}
