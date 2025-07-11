package com.project.shoestore.employee.domain.ports;

import com.project.shoestore.core.domain.ports.IRepositoryPort;
import com.project.shoestore.employee.domain.models.Employee;

public interface IEmployeeRepositoryPort extends IRepositoryPort<Employee, String> {}
