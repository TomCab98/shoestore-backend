package com.project.shoestore.employee.adapters.controllers;

import com.project.shoestore.employee.adapters.mappers.EmployeeControllerMapper;
import com.project.shoestore.core.adapters.controllers.ControllerAdapter;
import com.project.shoestore.employee.domain.models.Employee;
import com.project.shoestore.employee.domain.usecases.CreateEmployeeService;
import com.project.shoestore.employee.domain.usecases.DeleteEmployeeService;
import com.project.shoestore.employee.domain.usecases.FindEmployeeService;
import com.project.shoestore.employee.domain.usecases.UpdateEmployeeService;
import com.project.shoestore.employee.infrastructure.dtos.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeControllerAdapter extends ControllerAdapter<Employee, EmployeeDto, String>  {

  public EmployeeControllerAdapter(
    CreateEmployeeService createService,
    UpdateEmployeeService updateService,
    FindEmployeeService findService,
    DeleteEmployeeService deleteService,
    EmployeeControllerMapper mapper
  ) {
    super(createService, updateService, findService, deleteService, mapper);
  }
}
