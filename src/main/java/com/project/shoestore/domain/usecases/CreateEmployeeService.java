package com.project.shoestore.domain.usecases;

import com.project.shoestore.adapters.auth.EmployeeAuthAdapter;
import com.project.shoestore.core.domain.usecases.impl.CreateService;
import com.project.shoestore.domain.models.Employee;
import com.project.shoestore.domain.ports.IEmployeeRepositoryPort;

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
