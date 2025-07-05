package com.project.shoestore.employee.infrastructure.controllers;

import com.project.shoestore.employee.adapters.controllers.EmployeeControllerAdapter;
import com.project.shoestore.core.infrastructure.controllers.CoreController;
import com.project.shoestore.employee.infrastructure.dtos.EmployeeDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends CoreController<EmployeeDto, String> {
  public EmployeeController(EmployeeControllerAdapter adapter) {
    super(adapter);
  }
}
