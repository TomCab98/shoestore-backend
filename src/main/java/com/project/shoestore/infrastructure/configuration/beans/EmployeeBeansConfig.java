package com.project.shoestore.infrastructure.configuration.beans;

import com.project.shoestore.adapters.auth.EmployeeAuthAdapter;
import com.project.shoestore.adapters.repositories.EmployeeRepositoryAdapter;
import com.project.shoestore.domain.usecases.CreateEmployeeService;
import com.project.shoestore.domain.usecases.DeleteEmployeeService;
import com.project.shoestore.domain.usecases.FindEmployeeService;
import com.project.shoestore.domain.usecases.UpdateEmployeeService;
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
