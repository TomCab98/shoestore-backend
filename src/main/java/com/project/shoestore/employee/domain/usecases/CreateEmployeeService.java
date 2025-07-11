package com.project.shoestore.employee.domain.usecases;

import com.project.shoestore.employee.adapters.auth.EmployeeAuthAdapter;
import com.project.shoestore.core.domain.usecases.impl.CreateService;
import com.project.shoestore.employee.domain.models.Employee;
import com.project.shoestore.employee.domain.ports.IEmployeeRepositoryPort;

public class CreateEmployeeService extends CreateService<Employee, String> {
  private final EmployeeAuthAdapter auth;

  public CreateEmployeeService(IEmployeeRepositoryPort repository, EmployeeAuthAdapter auth) {
    super(repository);
    this.auth = auth;
  }

  @Override
  public Employee create(Employee model) {
    model.setPassword(auth.encodePassword(model.getPassword()));
    return super.create(model);
  }
}
