package com.project.shoestore.domain.ports;

import com.project.shoestore.core.domain.ports.IRepositoryPort;
import com.project.shoestore.domain.models.Employee;

public interface IEmployeeRepositoryPort extends IRepositoryPort<Employee, String> {}
