package com.project.shoestore.employee.infrastructure.config;

import com.project.shoestore.employee.adapters.auth.EmployeeAuthAdapter;
import com.project.shoestore.employee.adapters.repositories.EmployeeRepositoryAdapter;
import com.project.shoestore.employee.domain.usecases.CreateEmployeeService;
import com.project.shoestore.employee.domain.usecases.DeleteEmployeeService;
import com.project.shoestore.employee.domain.usecases.FindEmployeeService;
import com.project.shoestore.employee.domain.usecases.UpdateEmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeBeansConfig {
  @Bean
  public CreateEmployeeService createEmployeeService(EmployeeRepositoryAdapter repository, EmployeeAuthAdapter auth) {
    return new CreateEmployeeService(repository, auth);
  }

  @Bean
  public UpdateEmployeeService updateEmployeeService(EmployeeRepositoryAdapter repository) {
    return new UpdateEmployeeService(repository);
  }

  @Bean
  public DeleteEmployeeService deleteEmployeeService(EmployeeRepositoryAdapter repository, FindEmployeeService findEmployeeService) {
    return new DeleteEmployeeService(repository, findEmployeeService);
  }

  @Bean
  public FindEmployeeService findEmployeeService(EmployeeRepositoryAdapter repository) {
    return new FindEmployeeService(repository);
  }
}
