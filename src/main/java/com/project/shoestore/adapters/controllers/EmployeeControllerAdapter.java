package com.project.shoestore.adapters.controllers;

import com.project.shoestore.adapters.mappers.EmployeeControllerMapper;
import com.project.shoestore.core.adapters.controllers.ControllerAdapter;
import com.project.shoestore.domain.models.Employee;
import com.project.shoestore.domain.ports.IEmployeeControllerPort;
import com.project.shoestore.domain.usecases.CreateEmployeeService;
import com.project.shoestore.domain.usecases.DeleteEmployeeService;
import com.project.shoestore.domain.usecases.FindEmployeeService;
import com.project.shoestore.domain.usecases.UpdateEmployeeService;
import com.project.shoestore.infrastructure.dtos.EmployeeDto;
import org.springframework.stereotype.Component;

@Component
public class EmployeeControllerAdapter extends ControllerAdapter<Employee, EmployeeDto, String> implements IEmployeeControllerPort {

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
