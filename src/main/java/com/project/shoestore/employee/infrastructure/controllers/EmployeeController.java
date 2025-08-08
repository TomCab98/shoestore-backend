package com.project.shoestore.employee.infrastructure.controllers;

import com.project.shoestore.employee.adapters.controllers.EmployeeControllerAdapter;
import com.project.shoestore.core.infrastructure.controllers.CoreController;
import com.project.shoestore.employee.infrastructure.dtos.EmployeeDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@Tag(name = "Employee", description = "Endpoints for employee management")
public class EmployeeController extends CoreController<EmployeeDto, String> {
  public EmployeeController(EmployeeControllerAdapter adapter) {
    super(adapter);
  }
}
